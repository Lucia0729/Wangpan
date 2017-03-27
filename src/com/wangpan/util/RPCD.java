package com.wangpan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RPCD {

	private Map<Integer, String> mapRegion = new HashMap<Integer, String>();//地区
	private Map<Integer, Integer> Region_Province = new HashMap<Integer, Integer>();//地区与省
	private Map<Integer, String> mapProvince = new HashMap<Integer, String>();//省
	private Map<Integer, Integer> Province_City = new HashMap<Integer, Integer>();//省与市
	private Map<Integer, String> mapCity = new HashMap<Integer, String>();//市
	private Map<Integer, Integer> City_Area = new HashMap<Integer, Integer>();//市与镇
	private Map<Integer, String> mapArea = new HashMap<Integer, String>();//镇

	public JSONObject readfromjson() throws Exception {
		// TODO Auto-generated method stub
		System.out.println( System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir")+"/WebContent/Js/address.json");
		FileInputStream in = new FileInputStream(file);
		InputStreamReader read = new InputStreamReader(in);
		BufferedReader bufferedread = new BufferedReader(read);
		String json = "";
		String reada = "";
		while ((reada = bufferedread.readLine()) != null) {
			json += reada;
		}
		json="{"+json.substring(3,json.length()-1).replace("=", ":")+"};";
		JSONObject jsonobject = JSONObject.fromObject(json);
		return jsonobject;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RPCD P = new RPCD();
		JSONObject jsonobject = P.readfromjson();
		P.getRegions(jsonobject);

	}

	public void getRegions(JSONObject jsonobject) {
		// TODO Auto-generated method stub
		Object o1 = jsonobject.get("regionList");
		JSONArray jsonarray1 = JSONArray.fromObject(o1);
		int i = 0;
		int j = 0;
		int m = 0;
		int n = 0;
		for (Object json : jsonarray1) {
			JSONObject jsonobject1 = JSONObject.fromObject(json);
			mapRegion.put(++i, String.valueOf(jsonobject1.get("name")));

			Object o2 = jsonobject1.get("provinceList");
			JSONArray jsonarray2 = JSONArray.fromObject(o2);
			for (Object json2 : jsonarray2) {
				JSONObject jsonobject2 = JSONObject.fromObject(json2);
				mapProvince.put(++j, String.valueOf(jsonobject2.get("name")));
				Region_Province.put(j, i);

				Object o3 = jsonobject2.get("cityList");
				JSONArray jsonarray3 = JSONArray.fromObject(o3);
				for (Object json3 : jsonarray3) {
					JSONObject jsonobject3 = JSONObject.fromObject(json3);
					mapCity.put(++m, String.valueOf(jsonobject3.get("name")));
					Province_City.put(m, j);

					Object o4 = jsonobject3.get("areaList");
					JSONArray jsonarray4 = JSONArray.fromObject(o4);
					for (Object json4 : jsonarray4) {
						mapArea.put(++n, String.valueOf(json4));
						City_Area.put(n, m);
					}
				}
			}
		}
		// System.out.println(mapRegion.toString());
		// System.out.println(Region_Province.toString());
		// System.out.println(mapProvince.toString());
		// System.out.println(Province_City.toString());
		// System.out.println(mapCity.toString());
		// System.out.println(City_Area.toString());
		// System.out.println(mapArea.toString());
	}

}
