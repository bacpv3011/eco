package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eco.bean.Station;

public class StationApi {
	public List<Station> getStation(Map<String, String> queryParams) {
		List<Station> list = new ArrayList<>();
		list.add(new Station("D9","HUST"));
		list.add(new Station("95C","Hoàng Ngân"));
		return list;
	}

}
