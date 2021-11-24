package assets;

public enum VTBTicker implements Ticker {
    VTBA("vtbfam"), VTBB("vtbrcbsb"), VTBE("vtbfars"), VTBG("vtbfzb"), VTBH("vtbfacd"),
    VTBM("vtbfl"), VTBU("vtbfcresb"), VTBX("vtbfimb");

    /**
     * To visit the official site for the specific fund we need its page name:
     * https://www.vtbcapital-am.ru/products/bpif/...page_name.../investment_strategy/
     * For example: for VTBE its page is "vtbfars":
     * https://www.vtbcapital-am.ru/products/bpif/vtbfars/investment_strategy/
     */
    String fundOfficialSitePage;

    VTBTicker(String mark) {
        fundOfficialSitePage = mark;
    }

    public String getFundOfficialSitePage() {
        return fundOfficialSitePage;
    }
}
