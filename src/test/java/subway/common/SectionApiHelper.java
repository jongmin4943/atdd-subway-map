package subway.common;

import core.RestAssuredHelper;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.Map;

public class SectionApiHelper {
    public static final String SECTION_API_PATH = "/lines/{id}/sections";

    public static ExtractableResponse<Response> create(final Long lineId, final Long upStationId, final Long downStationId, final int distance) {
        final Map<String, Object> createLineRequest = createRequestFixture(upStationId, downStationId, distance);
        return RestAssuredHelper.post(SECTION_API_PATH, lineId, createLineRequest);
    }

    private static Map<String, Object> createRequestFixture(final Long upStationId, final Long downStationId, final int distance) {
        return Map.of(
                "upStationId", upStationId
                , "downStationId", downStationId
                , "distance", distance
        );
    }

}