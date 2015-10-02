/**
 */
package org.classupplier.impl;

import java.util.Map;
import java.util.concurrent.Semaphore;

import org.classupplier.ClassSupplierFactory;
import org.classupplier.ClassSupplierPackage;
import org.classupplier.Contribution;
import org.classupplier.Phase;
import org.classupplier.State;
import org.classupplier.Workspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.equinox.concurrent.future.IFuture;
import org.osgi.framework.Version;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ClassSupplierPackageImpl extends EPackageImpl implements ClassSupplierPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionToStateMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSchedulingRuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFutureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum phaseEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iProgressMonitorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType versionEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType semaphoreEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType coreExceptionEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.classupplier.ClassSupplierPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ClassSupplierPackageImpl() {
		super(eNS_URI, ClassSupplierFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link ClassSupplierPackage#eINSTANCE}
	 * when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ClassSupplierPackage init() {
		if (isInited)
			return (ClassSupplierPackage) EPackage.Registry.INSTANCE.getEPackage(ClassSupplierPackage.eNS_URI);

		// Obtain or create and register package
		ClassSupplierPackageImpl theClassSupplierPackage = (ClassSupplierPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ClassSupplierPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new ClassSupplierPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theClassSupplierPackage.createPackageContents();

		// Initialize created meta-data
		theClassSupplierPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theClassSupplierPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ClassSupplierPackage.eNS_URI, theClassSupplierPackage);
		return theClassSupplierPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContribution() {
		return contributionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_Name() {
		return (EAttribute) contributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_Language() {
		return (EAttribute) contributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_Version() {
		return (EAttribute) contributionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_Stage() {
		return (EAttribute) contributionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_ProjectName() {
		return (EAttribute) contributionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_StateHistory() {
		return (EReference) contributionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_State() {
		return (EReference) contributionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_DynamicEPackage() {
		return (EReference) contributionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_GeneratedEPackage() {
		return (EReference) contributionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Name() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Language() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Timestamp() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Number() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Version() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_Stage() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_ProjectName() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_DeployableUnitName() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_EPackage() {
		return (EAttribute) stateEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_DynamicEPackage() {
		return (EReference) stateEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_GeneratedEPackage() {
		return (EReference) stateEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspace() {
		return workspaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspace_Contributions() {
		return (EReference) workspaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkspace_ResourceSet() {
		return (EAttribute) workspaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionToStateMapEntry() {
		return versionToStateMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionToStateMapEntry_Key() {
		return (EAttribute) versionToStateMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersionToStateMapEntry_Value() {
		return (EReference) versionToStateMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISchedulingRule() {
		return iSchedulingRuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFuture() {
		return iFutureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructable() {
		return constructableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPhase() {
		return phaseEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIProgressMonitor() {
		return iProgressMonitorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVersion() {
		return versionEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSemaphore() {
		return semaphoreEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCoreException() {
		return coreExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassSupplierFactory getClassSupplierFactory() {
		return (ClassSupplierFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		contributionEClass = createEClass(CONTRIBUTION);
		createEAttribute(contributionEClass, CONTRIBUTION__NAME);
		createEAttribute(contributionEClass, CONTRIBUTION__LANGUAGE);
		createEAttribute(contributionEClass, CONTRIBUTION__VERSION);
		createEAttribute(contributionEClass, CONTRIBUTION__STAGE);
		createEAttribute(contributionEClass, CONTRIBUTION__PROJECT_NAME);
		createEReference(contributionEClass, CONTRIBUTION__STATE_HISTORY);
		createEReference(contributionEClass, CONTRIBUTION__STATE);
		createEReference(contributionEClass, CONTRIBUTION__DYNAMIC_EPACKAGE);
		createEReference(contributionEClass, CONTRIBUTION__GENERATED_EPACKAGE);

		stateEClass = createEClass(STATE);
		createEAttribute(stateEClass, STATE__NAME);
		createEAttribute(stateEClass, STATE__LANGUAGE);
		createEAttribute(stateEClass, STATE__TIMESTAMP);
		createEAttribute(stateEClass, STATE__NUMBER);
		createEAttribute(stateEClass, STATE__VERSION);
		createEAttribute(stateEClass, STATE__STAGE);
		createEAttribute(stateEClass, STATE__PROJECT_NAME);
		createEAttribute(stateEClass, STATE__DEPLOYABLE_UNIT_NAME);
		createEAttribute(stateEClass, STATE__EPACKAGE);
		createEReference(stateEClass, STATE__DYNAMIC_EPACKAGE);
		createEReference(stateEClass, STATE__GENERATED_EPACKAGE);

		workspaceEClass = createEClass(WORKSPACE);
		createEReference(workspaceEClass, WORKSPACE__CONTRIBUTIONS);
		createEAttribute(workspaceEClass, WORKSPACE__RESOURCE_SET);

		versionToStateMapEntryEClass = createEClass(VERSION_TO_STATE_MAP_ENTRY);
		createEAttribute(versionToStateMapEntryEClass, VERSION_TO_STATE_MAP_ENTRY__KEY);
		createEReference(versionToStateMapEntryEClass, VERSION_TO_STATE_MAP_ENTRY__VALUE);

		iSchedulingRuleEClass = createEClass(ISCHEDULING_RULE);

		iFutureEClass = createEClass(IFUTURE);

		constructableEClass = createEClass(CONSTRUCTABLE);

		// Create enums
		phaseEEnum = createEEnum(PHASE);

		// Create data types
		iProgressMonitorEDataType = createEDataType(IPROGRESS_MONITOR);
		versionEDataType = createEDataType(VERSION);
		semaphoreEDataType = createEDataType(SEMAPHORE);
		coreExceptionEDataType = createEDataType(CORE_EXCEPTION);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters
		addETypeParameter(iFutureEClass, "ResultType"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		contributionEClass.getESuperTypes().add(this.getConstructable());
		stateEClass.getESuperTypes().add(this.getConstructable());
		workspaceEClass.getESuperTypes().add(this.getISchedulingRule());

		// Initialize classes and features; add operations and parameters
		initEClass(contributionEClass, Contribution.class, "Contribution", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContribution_Name(), ecorePackage.getEString(), "name", "", 0, 1, Contribution.class, //$NON-NLS-1$ //$NON-NLS-2$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContribution_Language(), ecorePackage.getEString(), "language", null, 0, 1, //$NON-NLS-1$
				Contribution.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getContribution_Version(), this.getVersion(), "version", null, 0, 1, Contribution.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContribution_Stage(), this.getPhase(), "stage", "DEFINED", 0, 1, Contribution.class, //$NON-NLS-1$ //$NON-NLS-2$
				!IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getContribution_ProjectName(), ecorePackage.getEString(), "projectName", "", 0, 1, //$NON-NLS-1$ //$NON-NLS-2$
				Contribution.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_StateHistory(), this.getVersionToStateMapEntry(), null, "stateHistory", null, 0, //$NON-NLS-1$
				-1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_State(), this.getState(), null, "state", null, 0, 1, Contribution.class, //$NON-NLS-1$
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_DynamicEPackage(), ecorePackage.getEPackage(), null, "dynamicEPackage", null, 0, //$NON-NLS-1$
				1, Contribution.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_GeneratedEPackage(), ecorePackage.getEPackage(), null, "generatedEPackage", null, //$NON-NLS-1$
				0, 1, Contribution.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(contributionEClass, null, "apply", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(this.getIFuture());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(ecorePackage.getEPackage());
		g2.setEUpperBound(g3);
		initEOperation(op, g1);

		op = addEOperation(contributionEClass, null, "checkout", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(contributionEClass, this.getState(), "newState", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(contributionEClass, null, "delete", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getCoreException());

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getState_Name(), ecorePackage.getEString(), "name", null, 0, 1, State.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_Language(), ecorePackage.getEString(), "language", null, 0, 1, State.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_Timestamp(), ecorePackage.getEDate(), "timestamp", null, 0, 1, State.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_Number(), ecorePackage.getEInt(), "number", null, 0, 1, State.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_Version(), this.getVersion(), "version", null, 0, 1, State.class, !IS_TRANSIENT, //$NON-NLS-1$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_Stage(), this.getPhase(), "stage", "DEFINED", 0, 1, State.class, !IS_TRANSIENT, //$NON-NLS-1$ //$NON-NLS-2$
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_ProjectName(), ecorePackage.getEString(), "projectName", "", 0, 1, State.class, //$NON-NLS-1$ //$NON-NLS-2$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getState_DeployableUnitName(), ecorePackage.getEString(), "deployableUnitName", "", 0, 1, //$NON-NLS-1$ //$NON-NLS-2$
				State.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getState_EPackage(), theEcorePackage.getEFeatureMapEntry(), "ePackage", null, 0, 1, State.class, //$NON-NLS-1$
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_DynamicEPackage(), theEcorePackage.getEPackage(), null, "dynamicEPackage", null, 0, 1, //$NON-NLS-1$
				State.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getState_GeneratedEPackage(), theEcorePackage.getEPackage(), null, "generatedEPackage", null, 0, //$NON-NLS-1$
				1, State.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(stateEClass, null, "fireJobsCompleted", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		addEOperation(stateEClass, ecorePackage.getEString(), "formatVersion", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(stateEClass, null, "setProjectVersion", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getCoreException());

		op = addEOperation(stateEClass, null, "delete", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getCoreException());

		initEClass(workspaceEClass, Workspace.class, "Workspace", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspace_Contributions(), this.getContribution(), null, "contributions", null, 0, -1, //$NON-NLS-1$
				Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkspace_ResourceSet(), ecorePackage.getEResourceSet(), "resourceSet", null, 0, 1, //$NON-NLS-1$
				Workspace.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		addEOperation(workspaceEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, this.getContribution(), "createContribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEPackage(), "blueprint", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, this.getContribution(), "getContribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEObject(), "eObject", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, this.getContribution(), "getContribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEPackage(), "ePackage", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, this.getContribution(), "getContribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEString(), "projectName", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, null, "registerContribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getContribution(), "contribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, null, "unregisterContribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getContribution(), "contribution", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, this.getPhase(), "contains", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEPackage(), "blueprint", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(workspaceEClass, null, "delete", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEJavaObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getIProgressMonitor(), "monitor", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEException(op, this.getCoreException());

		initEClass(versionToStateMapEntryEClass, Map.Entry.class, "VersionToStateMapEntry", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				!IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionToStateMapEntry_Key(), this.getVersion(), "key", null, 0, 1, Map.Entry.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersionToStateMapEntry_Value(), this.getState(), null, "value", null, 0, 1, Map.Entry.class, //$NON-NLS-1$
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iSchedulingRuleEClass, ISchedulingRule.class, "ISchedulingRule", IS_ABSTRACT, IS_INTERFACE, //$NON-NLS-1$
				!IS_GENERATED_INSTANCE_CLASS);

		initEClass(iFutureEClass, IFuture.class, "IFuture", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(constructableEClass, Constructable.class, "Constructable", IS_ABSTRACT, IS_INTERFACE, //$NON-NLS-1$
				!IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(phaseEEnum, Phase.class, "Phase"); //$NON-NLS-1$
		addEEnumLiteral(phaseEEnum, Phase.DEFINED);
		addEEnumLiteral(phaseEEnum, Phase.MODELED);
		addEEnumLiteral(phaseEEnum, Phase.GENERATED);
		addEEnumLiteral(phaseEEnum, Phase.EXPORTED);
		addEEnumLiteral(phaseEEnum, Phase.INSTALLED);
		addEEnumLiteral(phaseEEnum, Phase.LOADED);

		// Initialize data types
		initEDataType(iProgressMonitorEDataType, IProgressMonitor.class, "IProgressMonitor", IS_SERIALIZABLE, //$NON-NLS-1$
				!IS_GENERATED_INSTANCE_CLASS);
		initEDataType(versionEDataType, Version.class, "Version", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(semaphoreEDataType, Semaphore.class, "Semaphore", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(coreExceptionEDataType, CoreException.class, "CoreException", IS_SERIALIZABLE, //$NON-NLS-1$
				!IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for
	 * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$
		addAnnotation(getState_EPackage(), source, new String[] { "kind", "group" }); //$NON-NLS-1$ //$NON-NLS-2$
		addAnnotation(getState_DynamicEPackage(), source, new String[] { "group", "#ePackage" }); //$NON-NLS-1$ //$NON-NLS-2$
		addAnnotation(getState_GeneratedEPackage(), source, new String[] { "group", "#ePackage" }); //$NON-NLS-1$ //$NON-NLS-2$
	}

} // ClassSupplierPackageImpl
