/**
 * Copyright 2012-2017 Kyrill Zotkin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.enterprisedomain.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.enterprisedomain.classmaker.ClassPlant;
import org.enterprisedomain.classmaker.CompletionListener;
import org.enterprisedomain.classmaker.Contribution;
import org.enterprisedomain.classmaker.Customizer;
import org.enterprisedomain.classmaker.Stage;
import org.enterprisedomain.classmaker.impl.CompletionListenerImpl;
import org.enterprisedomain.classmaker.impl.CustomizerImpl;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.Version;

public class TestEnterpriseDomain extends AbstractTest {

	private EObject o;
	private EPackage p;

	@Test
	public void classCreation() throws Exception {
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
		final EPackage readerEPackage = createEPackage("reader", "1.0");
		final EClass eClass = ecoreFactory.createEClass();
		eClass.setName("Book");
		final EAttribute pagesAttr = ecoreFactory.createEAttribute();
		pagesAttr.setName("totalPages");
		pagesAttr.setEType(EcorePackage.Literals.EINT);
		eClass.getEStructuralFeatures().add(pagesAttr);

		final EAttribute attr = ecoreFactory.createEAttribute();
		attr.setName("pagesRead");
		attr.setEType(EcorePackage.Literals.EINT);
		eClass.getEStructuralFeatures().add(attr);

		final EOperation op = ecoreFactory.createEOperation();
		op.setName("read");
		EParameter p = ecoreFactory.createEParameter();
		p.setEType(EcorePackage.Literals.EINT);
		p.setName("pagesRead");
		op.getEParameters().add(p);
		EAnnotation an = ecoreFactory.createEAnnotation();
		an.setSource("http://www.eclipse.org/emf/2002/GenModel");
		an.getDetails().put("body", "setPagesRead(getPagesRead() + pagesRead);");
		op.getEAnnotations().add(an);
		EAnnotation invocation = ecoreFactory.createEAnnotation();
		invocation.setSource(ClassPlant.INVOCATION_DELEGATE_URI);
		op.getEAnnotations().add(invocation);
		eClass.getEOperations().add(op);
		invocation = ecoreFactory.createEAnnotation();
		invocation.setSource(EcorePackage.eNS_URI);
		invocation.getDetails().put("invocationDelegates", ClassPlant.INVOCATION_DELEGATE_URI);
		readerEPackage.getEAnnotations().add(invocation);
		readerEPackage.getEClassifiers().add(eClass);

		assertNotNull(service);

		EPackage ePackage = service.produce(readerEPackage, getProgressMonitor());
		assertNotNull(ePackage);
		EClass theClass = (EClass) ePackage.getEClassifier(eClass.getName());
		EObject theObject = ePackage.getEFactoryInstance().create(theClass);

		int pages = 22;
		EAttribute objectPageAttr = (EAttribute) theClass.getEStructuralFeature(pagesAttr.getName());
		theObject.eSet(objectPageAttr, pages);
		assertEquals(pages, theObject.eGet(objectPageAttr));

		int readPagesCount = 11;
		EList<?> arguments = ECollections.asEList(readPagesCount);
		for (EOperation operation : theClass.getEAllOperations())
			if (operation.getName().equals(op.getName())) {
				EcoreUtil.getInvocationDelegateFactory(operation).createInvocationDelegate(operation)
						.dynamicInvoke((InternalEObject) theObject, arguments);
			}

		EStructuralFeature state = theClass.getEStructuralFeature(attr.getName());
		assertEquals(readPagesCount, theObject.eGet(state));

		assertEquals(eClass.getName(), theObject.getClass().getSimpleName());
		cleanup();
	}

	@Test
	public void osgiService() throws Exception {
		BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference<?> serviceReference = bundleContext.getServiceReference(ClassPlant.class);
		ClassPlant tested = (ClassPlant) bundleContext.getService(serviceReference);
		assertNotNull(tested);
		EPackage ePackage = createEPackage("deeds", "0.2");
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		final String className0 = "Hobby";
		eClass.setName(className0);
		ePackage.getEClassifiers().add(eClass);
		final String className1 = "Work";
		eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(className1);
		ePackage.getEClassifiers().add(eClass);

		ePackage = tested.produce(ePackage, getProgressMonitor());
		assertNotNull(ePackage);
		assertObjectClass(className0, ePackage);
		assertObjectClass(className1, ePackage);
		cleanup();
	}

	@Test
	public void metaModel() throws Exception {
		EcoreFactory factory = EcoreFactory.eINSTANCE;
		EPackage _package = createEPackage("meta", "");
		EClass metaClass = factory.createEClass();
		metaClass.setName("MetaObject");
		EAttribute nameAttribute = factory.createEAttribute();
		nameAttribute.setName("name");
		nameAttribute.setEType(EcorePackage.Literals.ESTRING);
		metaClass.getEStructuralFeatures().add(nameAttribute);
		EAttribute valueAttribute = factory.createEAttribute();
		valueAttribute.setName("value");
		valueAttribute.setEType(EcorePackage.Literals.EJAVA_OBJECT);
		metaClass.getEStructuralFeatures().add(valueAttribute);
		EOperation op = factory.createEOperation();
		op.setName("createInstance");
		op.setEType(metaClass);
		EAnnotation an = factory.createEAnnotation();
		an.setSource("http://www.eclipse.org/emf/2002/GenModel");
		an.getDetails().put("body", "return <%meta.MetaFactory%>.eINSTANCE.createMetaObject();");
		op.getEAnnotations().add(an);
		EAnnotation invocation = factory.createEAnnotation();
		invocation.setSource(ClassPlant.INVOCATION_DELEGATE_URI);
		op.getEAnnotations().add(invocation);
		metaClass.getEOperations().add(op);
		_package.getEClassifiers().add(metaClass);
		EAnnotation invocationDelegate = factory.createEAnnotation();
		invocationDelegate.setSource(EcorePackage.eNS_URI);
		invocationDelegate.getDetails().put("invocationDelegates", ClassPlant.INVOCATION_DELEGATE_URI);
		_package.getEAnnotations().add(invocationDelegate);

		EPackage ePackage = service.produce(_package);
		assertNotNull(ePackage);
		EClass resultClass = (EClass) ePackage.getEClassifier(metaClass.getName());
		EObject metaObject = ePackage.getEFactoryInstance().create(resultClass);
		EAttribute resultAttribute = (EAttribute) resultClass.getEStructuralFeature(nameAttribute.getName());
		metaObject.eSet(resultAttribute, "Notebook");
		assertEquals("Notebook", metaObject.eGet(resultAttribute));
		EObject object = ePackage.getEFactoryInstance().create(resultClass);
		EList<?> arguments = ECollections.emptyEList();
		EObject nativeObject = null;
		for (EOperation operation : resultClass.getEAllOperations())
			if (operation.getName().equals(op.getName())) {
				nativeObject = (EObject) EcoreUtil.getInvocationDelegateFactory(operation)
						.createInvocationDelegate(operation).dynamicInvoke((InternalEObject) object, arguments);
			}
		assertEquals(object.eClass(), nativeObject.eClass());
		cleanup();
	}

	@Test
	public void update() throws OperationCanceledException, InterruptedException, CoreException, ExecutionException {
		setPackageName("updateable");
		setClassName("Same");
		EcoreFactory f = EcoreFactory.eINSTANCE;
		p = createEPackage(getPackageName(), "0.1");
		final EClass cl = f.createEClass();
		cl.setName(getClassName());
		setAttributeName("a");
		final EAttribute a = f.createEAttribute();
		a.setName(getAttributeName());
		a.setEType(EcorePackage.Literals.EJAVA_OBJECT);
		cl.getEStructuralFeatures().add(a);
		p.getEClassifiers().add(cl);
		EPackage e0 = service.produce(p, getProgressMonitor());
		EClass c0 = (EClass) e0.getEClassifier(cl.getName());
		o = e0.getEFactoryInstance().create(c0);
		assertEquals(c0.getName(), o.getClass().getSimpleName());
		o.eSet(c0.getEStructuralFeature(a.getName()), "test");
		assertEquals("test", o.eGet(c0.getEStructuralFeature(a.getName())));
		final Version v1 = service.getWorkspace().getContribution(p).getVersion();
		final Registry packageRegistry = service.getWorkspace().getResourceSet().getPackageRegistry();
		assertNotNull(packageRegistry.getEPackage(p.getNsURI()));

		EPackage p2 = updateEPackage(p, "0.2");
		final EAttribute b = f.createEAttribute();
		setAttributeName("b");
		b.setName(getAttributeName());
		b.setEType(EcorePackage.Literals.EINT);
		((EClass) p2.getEClassifier(cl.getName())).getEStructuralFeatures().add(b);
		EPackage e1 = service.replace(p, p2, true);
		EClass cla = (EClass) e1.getEClassifier(cl.getName());
		o = e1.getEFactoryInstance().create(cla);
		assertEquals(cla.getName(), o.getClass().getSimpleName());
		o.eSet(cla.getEStructuralFeature(a.getName()), "test");
		assertEquals("test", o.eGet(cla.getEStructuralFeature(a.getName())));
		o.eSet(cla.getEStructuralFeature(b.getName()), 5);
		assertEquals(5, o.eGet(cla.getEStructuralFeature(b.getName())));
		Version v2 = service.getWorkspace().getContribution(p2).getVersion();
		assertTrue(v2.compareTo(v1) > 0);
		EClass c1 = (EClass) e0.getEClassifier(cl.getName());
		o = e0.getEFactoryInstance().create(c1);
		assertEquals(c1.getName(), o.getClass().getSimpleName());
		o.eSet(c1.getEStructuralFeature(a.getName()), "test");
		assertEquals("test", o.eGet(c1.getEStructuralFeature(a.getName())));
		assertNotNull(packageRegistry.getEPackage(p2.getNsURI()));

		service.getWorkspace().getContribution(service.computeProjectName(p.getName())).checkout(v1);
		EPackage p3 = updateEPackage(p, "0.3");
		EPackage e2 = service.replace(p, p3);
		assertEquals("http://" + e2.getName() + "/0.3", e2.getNsURI());
		cleanup();
	}

	@Test
	public void downgrade() throws OperationCanceledException, InterruptedException, ExecutionException, CoreException {
		setPackageName("pack");
		setClassName("C");
		setAttributeName("x");
		setAttributeType(EcorePackage.Literals.EJAVA_OBJECT);
		EPackage p = createAndTestEPackage();
		Contribution c = service.getWorkspace().getContribution(p, Stage.LOADED);
		p = c.getDomainModel().getDynamic();
		Version v = c.getVersion();

		EPackage p2 = updateEPackage(p, "1");
		EClass clazz = (EClass) p2.getEClassifier(getClassName());
		clazz.getEStructuralFeatures().remove(clazz.getEStructuralFeature(getAttributeName()));
		EPackage g = service.replace(p, p2, true);
		EClass gClazz = (EClass) g.getEClassifier(getClassName());
		EObject o = g.getEFactoryInstance().create(gClazz);
		assertNull(gClazz.getEStructuralFeature(getAttributeName()));
		assertEquals(getClassName(), o.getClass().getSimpleName());

		g = service.replace(p, p, v);
		gClazz = (EClass) g.getEClassifier(getClassName());
		o = g.getEFactoryInstance().create(gClazz);
		EAttribute a = (EAttribute) gClazz.getEStructuralFeature(getAttributeName());
		assertNotNull(a);
		assertEquals(getAttributeType(), a.getEType());
		assertEquals(getClassName(), o.getClass().getSimpleName());
		cleanup();
	}

	@Test
	public void recreate() throws CoreException, OperationCanceledException, InterruptedException, ExecutionException {
		setPackageName("pi");
		setClassName("C");
		setAttributeName("count");
		setAttributeType(EcorePackage.Literals.EJAVA_OBJECT);
		Contribution c = service.getWorkspace().getContribution(createAndTestEPackage(), Stage.LOADED);
		c.delete(getProgressMonitor());
		createAndTestEPackage();
		cleanup();
	}

	@Test
	public void version() throws OperationCanceledException, InterruptedException, ExecutionException, CoreException {
		setPackageName("some");
		setClassName("C");
		setAttributeName("c");
		setAttributeType(EcorePackage.Literals.EJAVA_OBJECT);
		EPackage p = createAndTestEPackage();
		Contribution c = service.getWorkspace().getContribution(p, Stage.LOADED);
		Version oldVersion = c.getRevision().getVersion();
		Version newVersion = c.nextVersion();
		EPackage g = service.replace(p, p, newVersion);
		assertNotNull(g);
		test(g, "c", new Object());
		g = service.replace(p, p, oldVersion);
		assertNotNull(g);
		test(g, "c", new Object());
		cleanup();
	}

	@Test
	public void changeModel()
			throws OperationCanceledException, InterruptedException, ExecutionException, CoreException {
		setPackageName("one");
		setClassName("T");
		setAttributeName("t");
		setAttributeType(EcorePackage.Literals.EJAVA_OBJECT);
		EPackage p = createAndTestAPI();
		setPackageName("another");
		EPackage p2 = updateEPackage(p, "1");
		p2.setName("another");
		p2.setNsPrefix("another");
		EClass cl = (EClass) p2.getEClassifier(getClassName());
		setClassName("P");
		cl.setName(getClassName());
		cl.getEStructuralFeature(getAttributeName());
		testAPIUpdate(p, p2, "t", EcorePackage.Literals.EJAVA_OBJECT, new Object());
		cleanup();
	}

	@Test
	public void immutable() throws NoSuchMethodException, CoreException, OperationCanceledException,
			InterruptedException, SecurityException, ClassNotFoundException, ExecutionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		setPackageName("immutable");
		EPackage eP = createEPackage(getPackageName(), "0.0.1");
		EClass eC = createEClass(getClassName());
		setAttributeName("C");
		setAttributeType(EcorePackage.Literals.EJAVA_OBJECT);
		EAttribute at = createEAttribute(getAttributeName(), getAttributeType());
		EcoreUtil.setSuppressedVisibility(at, EcoreUtil.SET, true);
		eC.getEStructuralFeatures().add(at);
		eP.getEClassifiers().add(eC);
		Contribution c = null;
		c = service.getWorkspace().createContribution(eP, getProgressMonitor());
		Customizer customizer = new CustomizerImpl() {

			@Override
			public void customize(EList<Object> args) {
				GenModel genModel = ((GenModel) args.get(1));
				genModel.setDynamicTemplates(true);
				genModel.setTemplateDirectory("platform:/plugin/org.genericdomain.tests/templates");
				genModel.setSuppressInterfaces(false);
			}

		};
		c.getCustomizers().put(ClassPlant.Stages.GENMODEL_SETUP, customizer);

		final Semaphore complete = new Semaphore(0);

		CompletionListener l = new CompletionListenerImpl() {

			@Override
			public void completed(Contribution result) throws Exception {
				try {
					EPackage e = null;
					Class<?> cl = null;
					try {
						e = result.getDomainModel().getGenerated();
						cl = e.getClass().getClassLoader().loadClass(getPackageName() + "." + getClassName());
						cl.getMethod("set" + getAttributeName(), Object.class);
					} catch (NoSuchMethodException ex) {
					}
					Method m = cl.getMethod("get" + getAttributeName(), new Class<?>[] {});
					EClass ec = (EClass) e.getEClassifier(getClassName());
					EObject eo = e.getEFactoryInstance().create(ec);
					Object o = new Object();
					eo.eSet(ec.getEStructuralFeature(getAttributeName()), o);
					assertEquals(o, m.invoke(eo, new Object[] {}));
				} catch (Exception e) {
					fail(e.getLocalizedMessage());
				} finally {
					complete.release();
				}
			}
		};
		c.addSaveCompletionListener(l);
		c.save(getProgressMonitor());
		complete.acquire();
		c.removeSaveCompletionListener(l);
		cleanup();
	}

	@Test
	public void package_() throws OperationCanceledException, InterruptedException, ExecutionException, CoreException {
		setPackageName("package");
		createAndTestEPackage();
		cleanup();
	}
}
