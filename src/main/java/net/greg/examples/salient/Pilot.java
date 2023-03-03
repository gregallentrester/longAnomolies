package net.greg.examples.salient;


/*
 While generating test data for a Kafka topic
 I implemented an if statement that didn't work.

 Given:
 guestRestrictions.getGuestId returns a Long

 https://docs.oracle.com/javase/7/docs/api/java/lang/Long.html#compareTo(java.lang.Long)
*/
public final class Pilot {

  private static final Long guestRestrictionsGetGuestIdLong = 88L;
  private static final Integer guestRestrictionsGetGuestId_UnLong = 88;


  public static void main (String args []) {

    if (guestRestrictionsGetGuestIdLong <= 91000000) {
          System.err.println(
            YLW + "\n\nLOGIC: " + NC + "if (guestRestrictionsGetGuestIdLong <= 91000000)" +
            GRN + "\nINVARIANT: guestRestrictionsGetGuestIdLong is actually type Long:" + NC +
            "\nQualified success BUT, possible precision loss/truncation"); }

    // Changed 9000000 to 91000000L - No Joy (no luck)
    if (guestRestrictionsGetGuestIdLong <= 91000000L) {
          System.err.println(
            YLW + "\n\nLOGIC: " + NC + "if (guestRestrictionsGetGuestIdLong <= 91000000L)" +
            GRN + "\nINVARIANT: guestRestrictionsGetGuestIdLong is actually type Long:" + NC +
            "\nActual success \nDid not experience: 'No Joy (no luck)'."); }


    if (guestRestrictionsGetGuestId_UnLong <= 91000000) {
          System.err.println(
            YLW + "\n\nLOGIC: " + NC + "if (guestRestrictionsGetGuestId_UnLong <= 91000000)" +
            GRN + "\nINVARIANT: guestRestrictionsGetGuestId_UnLong is actually type int:" + NC +
            "\nPlus, possible precision loss/truncation.\nQualified success"); }

    // Changed 9000000 to 91000000L - No Joy (no luck)
    if (guestRestrictionsGetGuestId_UnLong <= 91000000L) {
          System.err.println(
            YLW + "\n\nLOGIC: " + NC + "if (guestRestrictionsGetGuestId_UnLong <= 91000000L)" +
            GRN + "\nINVARIANT: guestRestrictionsGetGuestId_UnLong is actually type int:" + NC +
            "\nPlus, possible precision loss/truncation.\nQualified success"); }

    // What worked, proves that guestRestrictionsGetGuestIdL is actually a Long:
    int diff = guestRestrictionsGetGuestIdLong.compareTo(91000000L);

      if (diff <= 0 ) {
        System.err.println(
        YLW + "\n\nLOGIC: " + NC + "if (guestRestrictionsGetGuestIdLong.compareTo(91000000L)" +
        GRN + "\nINVARIANT: guestRestrictionsGetGuestIdLong is actually type Long:" + NC +
        "\nActual success");
      }
  }


  public static final String GRN = "\033[1;92m";
  public static final String YLW = "\033[1;93m";
  public static final String NC = "\u001B[0m";
}
