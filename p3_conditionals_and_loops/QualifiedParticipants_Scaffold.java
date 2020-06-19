/* *****************************************************************************
 *  Description: Simulate the participant recruitment process for a clinical study.
 *               Print out the numbers of the randomly selected participants who
 *               meet a desired criteria (with a given probability) until we reach 
 *               the total number of required participants.
 *
 * Example:
 * > java-introcs QualifiedParticipants 5 0.1
 * Person 11 qualified to participate.
 * Person 21 qualified to participate.
 * Person 26 qualified to participate.
 * Person 27 qualified to participate.
 * Person 35 qualified to participate.
 *
 **************************************************************************** */

public class QualifiedParticipants {
    public static void main(String[] args) {
        int participantsNeeded = Integer.parseInt(args[0]);
        __________ criteriaProbability = ___________________(args[1]);

        int participantsAgreed = _________;
        int participantNum = _________;
		
        while (________________) {
			// if a participant meets all criteria (with criteriaProbability), 
            // print out their participant number

			// increment participantNum
        }
    }
}
