class App {
  public static String date = "5/24/22";
  static int dayOfRental = 5;
  static double baseCharge = 29.99;
  static double electricCharge = 3.95;
  static double GpsCharge = 2.95;
  static double roadsideCharge = 3.95;
  static double surCharge = (baseCharge + (0.3 * baseCharge));
  static String surchargeoutput = String.format("%.2f", surCharge);

  private static double dailyCharge(int dayOfRental) {
    return dayOfRental * baseCharge;
  }

  static double RsGpsEt = electricCharge + GpsCharge + roadsideCharge;
  static double GpsEt = GpsCharge + electricCharge;
  static double RsEt = electricCharge + roadsideCharge;
  static double RsGps = roadsideCharge + GpsCharge;

  private static double optionsCalculator(int rentalDays, boolean tollCharge, boolean gpsAddOn, boolean roadsideAddOn,
      boolean under25) {
    if (tollCharge && gpsAddOn && roadsideAddOn && under25) {
      return rentalDays * (surCharge + RsGpsEt);
    } else if (!tollCharge && gpsAddOn && roadsideAddOn && under25) {
      return rentalDays * (surCharge + RsGps);
    } else if (tollCharge && !gpsAddOn && roadsideAddOn && under25) {
      return rentalDays * (surCharge + RsEt);
    } else if (tollCharge && gpsAddOn && !roadsideAddOn && under25) {
      return rentalDays * (surCharge + GpsEt);
    } else if (tollCharge && gpsAddOn && roadsideAddOn && !under25) {
      return rentalDays * (baseCharge + RsGpsEt);
    } else if (tollCharge && gpsAddOn && !roadsideAddOn && !under25) {
      return rentalDays * (baseCharge + GpsEt);
    } else if (tollCharge && !gpsAddOn && roadsideAddOn && !under25) {
      return rentalDays * (baseCharge + RsEt);
    } else if (!tollCharge && gpsAddOn && roadsideAddOn && !under25) {
      return rentalDays * (baseCharge + RsGps);
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
