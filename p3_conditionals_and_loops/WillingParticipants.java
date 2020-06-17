/* *****************************************************************************
 *  Description: Simulate the participant recruitment process for a clinical study.
 *               Print out the numbers of the participants who agree to participate
 *               in the study until we reach the total number of required
 *               participants.
 *
 * Example:
 * > java-introcs WillingParticipants 5
 * Person 9 agreed to participate
 * Person 17 agreed to participate
 * Person 27 agreed to participate
 * Person 38 agreed to participate
 * Person 43 agreed to participate
 *
 **************************************************************************** */

public class WillingParticipants {
    public static void main(String[] args) {
        int participantsNeeded = Integer.parseInt(args[0]);
        double criteriaProbability = Double.parseDouble(args[1]);

        int participantsAgreed = 0;
        int participantNum = 0;
		
        while (participantsAgreed < participantsNeeded) {
			// if a participant meets all criteria (with criteriaProbability), print out their patient number
            if (Math.random() < criteriaProbability) {
                System.out.println("Person " + participantNum + " agreed to participate");
                participantsAgreed++;
            }
			
			// increment participantNum
            participantNum++;
        }
        System.out.println("In total, " + participantNum + " + people were asked to participate in the study.");

    }
}
