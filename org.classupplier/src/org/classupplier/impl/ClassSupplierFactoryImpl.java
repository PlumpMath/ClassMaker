/**
 */
package org.classupplier.impl;

import java.util.Map;
import java.util.concurrent.Semaphore;

import org.classupplier.ClassSupplierFactory;
import org.classupplier.ClassSupplierPackage;
import org.classupplier.Contribution;
import org.classupplier.Messages;
import org.classupplier.Phase;
import org.classupplier.State;
import org.classupplier.Workspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osgi.framework.Version;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ClassSupplierFactoryImpl extends EFactoryImpl implements ClassSupplierFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ClassSupplierFactory init() {
		try {
			ClassSupplierFactory theClassSupplierFactory = (ClassSupplierFactory) EPackage.Registry.INSTANCE
					.getEFactory(ClassSupplierPackage.eNS_URI);
			if (theClassSupplierFactory != null) {
				return theClassSupplierFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassSupplierFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ClassSupplierFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ClassSupplierPackage.CONTRIBUTION:
			return createContribution();
		case ClassSupplierPackage.STATE:
			return createState();
		case ClassSupplierPackage.WORKSPACE:
			return createWorkspace();
		case ClassSupplierPackage.VERSION_TO_STATE_MAP_ENTRY:
			return (EObject) createVersionToStateMapEntry();
		default:
			throw new IllegalArgumentException(Messages.Class + eClass.getName() + Messages.NotValidClassifier);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ClassSupplierPackage.PHASE:
			return createPhaseFromString(eDataType, initialValue);
		case ClassSupplierPackage.IPROGRESS_MONITOR:
			return createIProgressMonitorFromString(eDataType, initialValue);
		case ClassSupplierPackage.VERSION:
			return createVersionFromString(eDataType, initialValue);
		case ClassSupplierPackage.SEMAPHORE:
			return createSemaphoreFromString(eDataType, initialValue);
		case ClassSupplierPackage.CORE_EXCEPTION:
			return createCoreExceptionFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(Messages.Datatype + eDataType.getName() + Messages.NotValidClassifier);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ClassSupplierPackage.PHASE:
			return convertPhaseToString(eDataType, instanceValue);
		case ClassSupplierPackage.IPROGRESS_MONITOR:
			return convertIProgressMonitorToString(eDataType, instanceValue);
		case ClassSupplierPackage.VERSION:
			return convertVersionToString(eDataType, instanceValue);
		case ClassSupplierPackage.SEMAPHORE:
			return convertSemaphoreToString(eDataType, instanceValue);
		case ClassSupplierPackage.CORE_EXCEPTION:
			return convertCoreExceptionToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(Messages.Datatype + eDataType.getName() + Messages.NotValidClassifier);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Contribution createContribution() {
		ContributionImpl contribution = new ContributionImpl();
		return contribution;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace createWorkspace() {
		WorkspaceImpl workspace = new WorkspaceImpl();
		return workspace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Version, State> createVersionToStateMapEntry() {
		VersionToStateMapEntryImpl versionToStateMapEntry = new VersionToStateMapEntryImpl();
		return versionToStateMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Phase createPhaseFromString(EDataType eDataType, String initialValue) {
		Phase result = Phase.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					Messages.Value + initialValue + Messages.NotValidEnumerator + eDataType.getName() + Messages.Quote);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPhaseToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IProgressMonitor createIProgressMonitorFromString(EDataType eDataType, String initialValue) {
		return (IProgressMonitor) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIProgressMonitorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Version createVersionFromString(EDataType eDataType, String initialValue) {
		return Version.parseVersion(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVersionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Semaphore createSemaphoreFromString(EDataType eDataType, String initialValue) {
		return (Semaphore) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSemaphoreToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CoreException createCoreExceptionFromString(EDataType eDataType, String initialValue) {
		return (CoreException) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCoreExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassSupplierPackage getClassSupplierPackage() {
		return (ClassSupplierPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassSupplierPackage getPackage() {
		return ClassSupplierPackage.eINSTANCE;
	}

} // ClassSupplierFactoryImpl
