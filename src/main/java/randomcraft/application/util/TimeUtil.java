package randomcraft.application.util;

import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class TimeUtil {

    static final Map<String, ZoneOffset> zoneOffsetMap = new HashMap<>();

    static {
        zoneOffsetMap.put(Constants.TIME_ZONE, ZoneOffset.of("+09:00"));
    }

    public static ZoneOffset getZoneOffset(String region) {
        return zoneOffsetMap.get(region);
    }
}
