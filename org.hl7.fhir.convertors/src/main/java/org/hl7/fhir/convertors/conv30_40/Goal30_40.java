package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Goal30_40 {

    public static org.hl7.fhir.dstu3.model.Goal convertGoal(org.hl7.fhir.r4.model.Goal src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Goal tgt = new org.hl7.fhir.dstu3.model.Goal();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasLifecycleStatus())
            tgt.setStatusElement(convertGoalStatus(src.getLifecycleStatusElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_30_40.convertCodeableConcept(src.getPriority()));
        if (src.hasDescription())
            tgt.setDescription(VersionConvertor_30_40.convertCodeableConcept(src.getDescription()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasStart())
            tgt.setStart(VersionConvertor_30_40.convertType(src.getStart()));
        if (src.hasTarget())
            tgt.setTarget(convertGoalTargetComponent(src.getTargetFirstRep()));
        if (src.hasStatusDate())
            tgt.setStatusDateElement(VersionConvertor_30_40.convertDate(src.getStatusDateElement()));
        if (src.hasStatusReason())
            tgt.setStatusReasonElement(VersionConvertor_30_40.convertString(src.getStatusReasonElement()));
        if (src.hasExpressedBy())
            tgt.setExpressedBy(VersionConvertor_30_40.convertReference(src.getExpressedBy()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAddresses()) tgt.addAddresses(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOutcomeCode()) tgt.addOutcomeCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getOutcomeReference()) tgt.addOutcomeReference(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Goal convertGoal(org.hl7.fhir.dstu3.model.Goal src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Goal tgt = new org.hl7.fhir.r4.model.Goal();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setLifecycleStatusElement(convertGoalStatus(src.getStatusElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_30_40.convertCodeableConcept(src.getPriority()));
        if (src.hasDescription())
            tgt.setDescription(VersionConvertor_30_40.convertCodeableConcept(src.getDescription()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasStart())
            tgt.setStart(VersionConvertor_30_40.convertType(src.getStart()));
        if (src.hasTarget())
            tgt.addTarget(convertGoalTargetComponent(src.getTarget()));
        if (src.hasStatusDate())
            tgt.setStatusDateElement(VersionConvertor_30_40.convertDate(src.getStatusDateElement()));
        if (src.hasStatusReason())
            tgt.setStatusReasonElement(VersionConvertor_30_40.convertString(src.getStatusReasonElement()));
        if (src.hasExpressedBy())
            tgt.setExpressedBy(VersionConvertor_30_40.convertReference(src.getExpressedBy()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAddresses()) tgt.addAddresses(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getOutcomeCode()) tgt.addOutcomeCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getOutcomeReference()) tgt.addOutcomeReference(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> convertGoalStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Goal.GoalStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Goal.GoalLifecycleStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.PROPOSED);
                break;
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACCEPTED);
                break;
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.PLANNED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case ONTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case AHEADOFTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case BEHINDTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case SUSTAINING:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case ACHIEVED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.COMPLETED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ONHOLD);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ENTEREDINERROR);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.REJECTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Goal.GoalStatus> convertGoalStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Goal.GoalStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Goal.GoalStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.PROPOSED);
                break;
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ACCEPTED);
                break;
            case PLANNED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.PLANNED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ACHIEVED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ONHOLD);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ENTEREDINERROR);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.REJECTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.r4.model.Goal.GoalTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(VersionConvertor_30_40.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertor_30_40.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertor_30_40.convertType(src.getDue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.r4.model.Goal.GoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(VersionConvertor_30_40.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertor_30_40.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertor_30_40.convertType(src.getDue()));
        return tgt;
    }
}
