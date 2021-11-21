package assets;

public enum VTBTicker implements Ticker {
    VTBA("vtbfam"), VTBB("vtbrcbsb"), VTBE("vtbfars"), VTBG("vtbfzb"), VTBH("vtbfacd"),
    VTBM("vtbfl"), VTBU("vtbfcresb"), VTBX("vtbfimb");

    String pageOfTheFundOnTheOfficialSite;
    //Example: to visit the official site for VTBE we need "vtbfars" after
    // https://www.vtbcapital-am.ru/products/bpif/:
    // https://www.vtbcapital-am.ru/products/bpif/vtbfars/investment_strategy/

    VTBTicker(String mark) {
        pageOfTheFundOnTheOfficialSite = mark;
    }

    public String getMarker() {
        return pageOfTheFundOnTheOfficialSite;
    }
}
