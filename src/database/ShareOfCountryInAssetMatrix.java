package database;

import assets.FinExTicker;
import assets.Ticker;
import assets.VTBTicker;
import diversificationCriterion.Country;

import java.util.*;

public class ShareOfCountryInAssetMatrix {
    private static final Map<Ticker, Double[]> coefficientMap = new HashMap<>();

    private ShareOfCountryInAssetMatrix() {
    }

    public static double getShare(Country country, Ticker ticker) {
        return coefficientMap.get(ticker)[country.getIndex()];
    }

    static {
        var arraySize = Country.values().length;
        var coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.China.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXCN, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Germany.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXDE, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Japan.getIndex()] = .1755;
        coefficientArray[Country.France.getIndex()] = .1175;
        coefficientArray[Country.Great_Britain.getIndex()] = .1165;
        coefficientArray[Country.Canada.getIndex()] = .1165;
        coefficientArray[Country.Switzerland.getIndex()] = .112;
        coefficientArray[Country.Germany.getIndex()] = .086;
        coefficientArray[Country.Australia.getIndex()] = .078;
        coefficientArray[Country.Netherlands.getIndex()] = .076;
        coefficientArray[Country.Denmark.getIndex()] = .024;
        coefficientArray[Country.Spain.getIndex()] = .023;
        coefficientArray[Country.Hong_Kong.getIndex()] = .017;
        coefficientArray[Country.Sweden.getIndex()] = .017;
        coefficientArray[Country.Italy.getIndex()] = .012;
        coefficientArray[Country.Finland.getIndex()] = .01;
        coefficientArray[Country.Singapore.getIndex()] = .009;
        coefficientArray[Country.Ireland.getIndex()] = .006;
        coefficientArray[Country.Belgium.getIndex()] = .004;
        coefficientMap.put(FinExTicker.FXDM, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = .457;
        coefficientArray[Country.Japan.getIndex()] = .181;
        coefficientArray[Country.China.getIndex()] = .18;
        coefficientArray[Country.Taiwan.getIndex()] = .077;
        coefficientArray[Country.South_Korea.getIndex()] = .047;
        coefficientArray[Country.Sweden.getIndex()] = .024;
        coefficientArray[Country.France.getIndex()] = .021;
        coefficientArray[Country.Poland.getIndex()] = .013;
        coefficientMap.put(FinExTicker.FXES, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = .957;
        coefficientArray[Country.Luxembourg.getIndex()] = .043;
        coefficientMap.put(FinExTicker.FXFA, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientMap.put(FinExTicker.FXGD, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXIM, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXIP, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXIT, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Kazakhstan.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXKZ, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXMM, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Russia.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXRB, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = .957;
        coefficientArray[Country.Luxembourg.getIndex()] = .043;
        coefficientMap.put(FinExTicker.FXRD, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Russia.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXRL, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Russia.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXRU, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = .4;
        coefficientArray[Country.Japan.getIndex()] = .2;
        coefficientArray[Country.China.getIndex()] = .115;
        coefficientArray[Country.Great_Britain.getIndex()] = .113;
        coefficientArray[Country.Germany.getIndex()] = .086;
        coefficientArray[Country.Australia.getIndex()] = .055;
        coefficientArray[Country.Russia.getIndex()] = .031;
        coefficientMap.put(FinExTicker.FXRW, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXTB, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXTP, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(FinExTicker.FXUS, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = .4;
        coefficientArray[Country.Japan.getIndex()] = .2;
        coefficientArray[Country.China.getIndex()] = .115;
        coefficientArray[Country.Great_Britain.getIndex()] = .113;
        coefficientArray[Country.Germany.getIndex()] = .086;
        coefficientArray[Country.Australia.getIndex()] = .055;
        coefficientArray[Country.Russia.getIndex()] = .031;
        coefficientMap.put(FinExTicker.FXWO, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(VTBTicker.VTBA, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Russia.getIndex()] = 1.;
        coefficientMap.put(VTBTicker.VTBB, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.China.getIndex()] = .3101;
        coefficientArray[Country.Taiwan.getIndex()] = .1616;
        coefficientArray[Country.India.getIndex()] = .1318;
        coefficientArray[Country.South_Korea.getIndex()] = .1257;
        coefficientArray[Country.Brazil.getIndex()] = .0369;
        coefficientArray[Country.Russia.getIndex()] = .0344;
        coefficientArray[Country.South_Africa.getIndex()] = .0317;
        coefficientArray[Country.Saudi_Arabia.getIndex()] = .0293;
        coefficientArray[Country.Thailand.getIndex()] = .0192;
        coefficientArray[Country.Mexico.getIndex()] = .0181;
        coefficientArray[Country.Malaysia.getIndex()] = .015;
        coefficientArray[Country.Indonesia.getIndex()] = .0145;
        coefficientMap.put(VTBTicker.VTBE, coefficientArray);//add

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientMap.put(VTBTicker.VTBG, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.USA.getIndex()] = 1.;
        coefficientMap.put(VTBTicker.VTBH, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Russia.getIndex()] = 1.;
        coefficientMap.put(VTBTicker.VTBM, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Russia.getIndex()] = 1.;
        coefficientMap.put(VTBTicker.VTBU, coefficientArray);

        coefficientArray = new Double[arraySize];
        Arrays.fill(coefficientArray, 0.);
        coefficientArray[Country.Russia.getIndex()] = 1.;
        coefficientMap.put(VTBTicker.VTBX, coefficientArray);
    }
}
