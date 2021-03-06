/**
 * Copyright 2017 Kyrill Zotkin
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.enterprisedomain.classmaker.impl;

import java.util.concurrent.Semaphore;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.enterprisedomain.classmaker.ClassMakerFactory;
import org.enterprisedomain.classmaker.ClassMakerPackage;
import org.enterprisedomain.classmaker.ClassPlant;
import org.enterprisedomain.classmaker.CompletionListener;
import org.enterprisedomain.classmaker.Contribution;
import org.enterprisedomain.classmaker.Messages;
import org.enterprisedomain.classmaker.Revision;
import org.enterprisedomain.classmaker.State;
import org.enterprisedomain.classmaker.Workspace;
import org.enterprisedomain.classmaker.core.ClassMakerOSGi;
import org.enterprisedomain.classmaker.util.ModelUtil;
import org.osgi.framework.Version;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Class
 * Plant</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.enterprisedomain.classmaker.impl.ClassPlantImpl#getWorkspace <em>Workspace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassPlantImpl extends EObjectImpl implements ClassPlant {
	/**
	 * The cached value of the '{@link #getWorkspace() <em>Workspace</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getWorkspace()
	 * @generated
	 * @ordered
	 */
	protected Workspace workspace;

	private Semaphore lock = new Semaphore(0);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ClassPlantImpl() {
		super();
		workspace = ClassMakerFactory.eINSTANCE.createWorkspace();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassMakerPackage.Literals.CLASS_PLANT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace getWorkspace() {
		if (workspace != null && workspace.eIsProxy()) {
			InternalEObject oldWorkspace = (InternalEObject) workspace;
			workspace = (Workspace) eResolveProxy(oldWorkspace);
			if (workspace != oldWorkspace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassMakerPackage.CLASS_PLANT__WORKSPACE,
							oldWorkspace, workspace));
			}
		}
		return workspace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace basicGetWorkspace() {
		return workspace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspace(Workspace newWorkspace) {
		Workspace oldWorkspace = workspace;
		workspace = newWorkspace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassMakerPackage.CLASS_PLANT__WORKSPACE,
					oldWorkspace, workspace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage produce(EPackage dynamicModel) throws CoreException {
		IProgressMonitor monitor = ClassMakerOSGi.getInstance().getProgressMonitor();
		return produce(dynamicModel, monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage produce(EPackage dynamicModel, IProgressMonitor monitor) throws CoreException {
		try {
			Contribution contrib = getWorkspace().createContribution(dynamicModel, monitor);
			contrib.addSaveCompletionListener(yieldResultListener);
			contrib.save(monitor);
			lock.acquire();
			return contrib.getDomainModel().getGenerated();
		} catch (CoreException e) {
			ClassMakerOSGi.getInstance().getLog().log(e.getStatus());
			throw e;
		} catch (InterruptedException e) {
			monitor.setCanceled(true);
			throw new CoreException(ClassMakerOSGi.createWarningStatus(Messages.APINoResult));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage replace(EPackage queryModel, EPackage dynamicModel) throws CoreException {
		return replace(queryModel, dynamicModel, false);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage replace(EPackage queryModel, EPackage dynamicModel, IProgressMonitor monitor) throws CoreException {
		return replace(queryModel, dynamicModel, false, monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage replace(EPackage queryModel, EPackage dynamicModel, boolean changeVersion) throws CoreException {
		IProgressMonitor monitor = ClassMakerOSGi.getInstance().getProgressMonitor();
		return replace(queryModel, dynamicModel, changeVersion, monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage replace(EPackage queryModel, EPackage dynamicModel, boolean changeVersion, IProgressMonitor monitor)
			throws CoreException {
		Version version = null;
		Contribution contribution = getWorkspace().getContribution(queryModel, false);
		if (contribution == null) {
			contribution = getWorkspace().getContribution(queryModel, true);
			if (contribution != null) {
				version = contribution.getVersion();
				if (changeVersion)
					version = contribution.newVersion(version, false, false, true);
			} else
				return null;
		} else if (changeVersion)
			version = contribution.nextVersion();
		else
			version = contribution.getVersion();
		return replace(queryModel, dynamicModel, version, monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage replace(EPackage queryModel, EPackage dynamicModel, Version version) throws CoreException {
		IProgressMonitor monitor = ClassMakerOSGi.getInstance().getProgressMonitor();
		return replace(queryModel, dynamicModel, version, monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EPackage replace(EPackage queryModel, EPackage dynamicModel, Version version, IProgressMonitor monitor)
			throws CoreException {
		try {
			Contribution contribution = getWorkspace().getContribution(queryModel, false);
			if (contribution == null) {
				contribution = getWorkspace().getContribution(queryModel, true);
				if (contribution != null) {
					EPackage existingModel = contribution.getDomainModel().getDynamic();
					if (ModelUtil.ePackagesAreEqual(existingModel, queryModel, false)) {
						Revision revision = null;
						if (version.compareTo(contribution.getVersion()) < 0) {
							if (!contribution.getRevisions().containsKey(version))
								return null;
							revision = contribution.getRevisions().get(version);
							contribution.checkout(revision.getVersion());
						} else
							revision = contribution.createRevision(monitor);
						revision.getDomainModel().setDynamic(EcoreUtil.copy(dynamicModel));
					}
				} else
					return null;
			} else {
				EPackage existingModel = contribution.getDomainModel().getDynamic();
				if (ModelUtil.ePackagesAreEqual(existingModel, queryModel, true)) {
					Revision revision = contribution.getRevision();
					if (version.compareTo(contribution.getVersion()) > 0) {
						revision = contribution.newRevision(version);
						State state = revision.getState();
						state.copyModel(contribution.getState());
						revision.create(monitor);
						String commitId = state.initialize();
						contribution.checkout(revision.getVersion(), state.getTimestamp(), commitId);
					} else if (version.compareTo(contribution.getVersion()) < 0) {
						if (!contribution.getRevisions().containsKey(version))
							return null;
						revision = contribution.getRevisions().get(version);
						contribution.checkout(revision.getVersion());
					}
					revision.getDomainModel().setDynamic(EcoreUtil.copy(dynamicModel));
				}
			}
			contribution.addSaveCompletionListener(yieldResultListener);
			contribution.save(monitor);
			lock.acquire();
			return contribution.getDomainModel().getGenerated();
		} catch (InterruptedException e) {
			monitor.setCanceled(true);
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void delete(String packageName, IProgressMonitor monitor) throws CoreException {
		Contribution contribution = getWorkspace().getContribution(computeProjectName(packageName));
		if (contribution != null)
			contribution.delete(monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String computeProjectName(String packageName) {
		return CodeGenUtil.safeName(packageName.toLowerCase());
	}

	private CompletionListener yieldResultListener = new CompletionListenerImpl() {

		@Override
		public void completed(Contribution result) throws Exception {
			result.getState().setSaving(false);
			lock.release();
		}

	};

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ClassMakerPackage.CLASS_PLANT__WORKSPACE:
			if (resolve)
				return getWorkspace();
			return basicGetWorkspace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ClassMakerPackage.CLASS_PLANT__WORKSPACE:
			setWorkspace((Workspace) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ClassMakerPackage.CLASS_PLANT__WORKSPACE:
			setWorkspace((Workspace) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ClassMakerPackage.CLASS_PLANT__WORKSPACE:
			return workspace != null;
		}
		return super.eIsSet(featureID);
	}

} // ClassPlantImpl
