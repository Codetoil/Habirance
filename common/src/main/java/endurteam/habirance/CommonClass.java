package endurteam.habirance;

import endurteam.habirance.platform.Services;

public class CommonClass {
    public static void construction() {
        Services.init();
        Constants.LOG.info("Running common init on {} {}", Services.PLATFORM.getPlatformName(),
                Services.PLATFORM.getEnvironmentName());
    }

    public static void setup() {

    }
}
