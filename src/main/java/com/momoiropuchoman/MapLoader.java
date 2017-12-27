package com.momoiropuchoman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

class MapLoader implements Common {
	static Mass[][] load(String name) {
		Mass[][] map = null;
		String fieldPath = path + "field/" + name + "/";
		try {
			FileInputStream fis = new FileInputStream(fieldPath + "map");
			InputStreamReader ir = new InputStreamReader(fis , "UTF-8");
			BufferedReader br = new BufferedReader(ir);

	    	// マップは縦×横で表現
			int row = Integer.parseInt(br.readLine());
			int col = Integer.parseInt(br.readLine());
			map = new Mass[col][row];

			for(int j = 0; j < row; j++) {
				String str = br.readLine();
				for(int i = 0; i < col; i++) {
					map[i][j] = new Mass(str.charAt(i));
				}
			}

			br.close();
			ir.close();
			fis.close();

		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("えらー");
		}

		return map;
	}
}