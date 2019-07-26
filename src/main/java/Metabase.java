import org.json.JSONObject;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;


class Metabase {

    static final String METABASE_SITE_URL = "<your metabase url>";
    static final String METABASE_SECRET_KEY = "<your metabase secret key>";
    static final String OPTIONS_EXAMPLE = "#theme=night&bordered=true&titled=true";

    public static Jwt encodeRequest(String request) {
        return JwtHelper.encode(request, new MacSigner(METABASE_SECRET_KEY));
    }
    
    public static String getEmbeddedRequestUrl(String request) {
    	String url = METABASE_SITE_URL + "/embed/dashboard/" + encodeRequest(request).getEncoded();
        return url;
    }
    
    public static String getEmbeddedRequestUrl(String request, String options) {
    	String url = METABASE_SITE_URL + "/embed/dashboard/" + encodeRequest(request).getEncoded() + options;
        return url;
    }
    
    public static String getEmbeddedRequestUrl(JSONObject request) {
        return getEmbeddedRequestUrl(request.toString());
    }
    
    public static String getEmbeddedRequestUrl(JSONObject request, String options) {
        return getEmbeddedRequestUrl(request.toString(), options);
    } 

}