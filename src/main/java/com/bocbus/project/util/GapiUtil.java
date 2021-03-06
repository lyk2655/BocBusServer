package com.bocbus.project.util;

import java.util.Collections;
import java.util.Iterator;

import com.bocbus.project.bean.GAPI_DISTANCE;
import com.bocbus.project.bean.GAPI_DISTANCE_PARAMETERS;
import com.bocbus.project.bean.GAPI_DISTANCE_RESULT;
import com.google.gson.Gson;

public class GapiUtil {
	// 距离测量 1-1
	public static GAPI_DISTANCE getDistance(GAPI_DISTANCE_PARAMETERS pa) {
		String ip = "http://restapi.amap.com/v3/distance";
		String param = "key=" + pa.getKey() + "&origins=" + pa.getOrigins() + "&destination=" + pa.getDestination()
				+ "&type=" + pa.getType();
		// String ip = "http://restapi.amap.com/v3/distance";
		// String param="key=8ad12a9140feb5b3ebdcd83abf021d45&origins=116.481028,39.989643|114.481028,39.989643|115.481028,39.989643&destination=114.465302,40.004717&type=1";
		String dis = MyHttpRequest.sendGet(ip, param, "utf-8");
		Gson gsonRequest = new Gson();
		GAPI_DISTANCE distance = gsonRequest.fromJson(dis, GAPI_DISTANCE.class);
		return distance;
	}

	public static GAPI_DISTANCE_RESULT getMinDistance(GAPI_DISTANCE distances) {
		// 查询不成功，返回-1
		
		if (distances.getResults() == null || distances.getResults().isEmpty() || distances.getStatus().equals("0")) {
			return null;
		}
		Iterator<GAPI_DISTANCE_RESULT> i = distances.getResults().iterator();
		GAPI_DISTANCE_RESULT candidate = i.next();

        while (i.hasNext()) {
        	GAPI_DISTANCE_RESULT next = i.next();
            if (next.compareTo(candidate) < 0)
                candidate = next;
        }
        
        //第二种实现取最小值
        //GAPI_DISTANCE_RESULT min = Collections.min(distances.getResults());
        //System.out.println("min\n"+min.toString());
        return candidate;
	}
	// 距离测量 1-n

	public static void main(String[] args) {
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(
				"113.865479,22.573118|116.481028,39.989643|114.481028,39.989643|115.481028,39.989643",
				"113.882852,22.56638");
		GAPI_DISTANCE dis = getDistance(pa);
		//System.out.println(pa);
		System.out.println("[dis]"+dis);
		System.out.println("[min]" + getMinDistance(dis).toString());
	}
}
