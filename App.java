class App {
  public static String date = "5/24/22";
  static int dayOfRental = 5;
  static double baseCharge = 29.99;
  static double electricCharge = 3.95 + baseCharge;
  static double GpsCharge = 2.95 + baseCharge;
  static double roadsideCharge = baseCharge + 3.95;
  static double surCharge = (baseCharge + (0.3 * baseCharge));
  static String surchargeoutput = String.format("%.2f", surCharge);

  private static double dailyCharge(int dayOfRental) {
    return dayOfRental * baseCharge;
  }

  private static double optionsCalculator(int rentalDays, boolean tollCharge, boolean gpsAddOn, boolean roadsideAddOn,
      boolean under25) {
    if (tollCharge == true && gpsAddOn == true && roadsideAddOn == true && under25 == true) {
      return rentalDays * (surCharge + 3.95 + 2.95 + 3.95);
    } else if (tollCharge == false && gpsAddOn == true && roadsideAddOn == true && under25 == true) {
      return rentalDays * (surCharge + 2.95 + 3.95);
    } else if (tollCharge == true && gpsAddOn == false && roadsideAddOn == true && under25 == true) {
      return rentalDays * (surCharge + 3.95 + 3.95);
    } else if (tollCharge == true && gpsAddOn == true && roadsideAddOn == false && under25 == true) {
      return rentalDays * (surCharge + 2.95 + 3.95);
    } else if (tollCharge == true && gpsAddOn == true && roadsideAddOn == true && under25 == false) {
      return rentalDays * (baseCharge + 3.95 + 2.95 + 3.95);
    } else if (tollCharge == true && gpsAddOn == true && roadsideAddOn == false && under25 == false) {
      return rentalDays * (baseCharge + 3.95 + 2.95);
    } else if (tollCharge == true && gpsAddOn == false && roadsideAddOn == true && under25 == false) {
      return rentalDays * (baseCharge + 3.95 + 3.95);
    } else if (tollCharge == false && gpsAddOn == true && roadsideAddOn == true && under25 == false) {
      return rentalDays * (baseCharge + 2.95 + 3.95);
    } else {
      return 0;
    }
  }

  public static void optionalOutput(int rentalDays, boolean tollCharge, boolean gpsAddOn, boolean roadsideAddOn,
      boolean under25) {
    double total = optionsCalculator(rentalDays, tollCharge, gpsAddOn, roadsideAddOn, under25);
    String roundToCent = String.format("%.2f", total);
    System.out.println(
        "Your grand total for a 5 day renatal on a unit with; GPS, Electric Toll pass, and roadside assistance, without a surcharge will be: "
            + roundToCent);
  }

  public static void main(String args[]) {
    System.out.println(date);

    System.out.println("Daily Charge:" + baseCharge);

    System.out.println("Daily charge for electric toll tag: " + electricCharge);

    System.out.println("Daily charge for unit with GPS: " + GpsCharge);

    System.out.println("Daily charge for unit with roadside assistance" + roadsideCharge);

    System.out.print("Daily charge for customer's under 25: " + surchargeoutput);

    System.out.print("The Charge for holding a base unit for 5 days: " + dailyCharge(dayOfRental));

    App.optionalOutput(5, true, true, true, false);
  }

}
