class CoffeMachine {
    void boil(HotDrink hd, int temperature) {
        System.out.println("Boiling at " + temperature + " degrees Celsius.");
    }

    void mix(HotDrink hd) {
        System.out.println("Mixing.");
    }

    void stir(HotDrink hd) {
        System.out.println("Stirring.");
    }

    //void handOut(HotDrink hd) {
    //    System.out.println(hd);
    //}

    // Template metódus
    HotDrink prepareHotDrink(HotDrink hd) {
        System.out.println("Preparing hot drink...");
        boil(hd, hd.getBoilingTemperature());
        mix(hd);
        stir(hd);
        System.out.println("Hot drink prepared.");
        //handOut(hd);
        return hd;
    }

    // Factory metódus
    public HotDrink hotDrinkFactory(String type, String extras) {
        HotDrink hd = null;

        switch (type.toLowerCase()) {
            case "coffee":
                hd = new HotCoffee();
                break;
            case "tea":
                hd = new HotTea();
                break;
            default:
                System.out.println("Invalid type.");
                return null;
        }

        for (char extra : extras.toCharArray()) {
            switch (extra) {
                case 's':
                    hd = new SugarDecorator(hd);
                    break;
                case 'm':
                    hd = new MilkDecorator(hd);
                    break;
                default:
                    System.out.println("Extra '" + extra + "' is not recognized.");
            }
        }

        prepareHotDrink(hd);

        return hd;
    }
}
