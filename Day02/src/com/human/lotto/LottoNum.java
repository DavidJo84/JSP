package com.human.lotto;

import java.util.ArrayList;
import java.util.Collections;

public class LottoNum {
	int num1;
	int num2;

	public ArrayList<Integer> lottoAll() {
		ArrayList<Integer> lottoNum = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			boolean flag = true;
			int num = (int) (Math.random() * 45 + 1);

			if (lottoNum.size() != 0) {
				for (int j = 0; j < lottoNum.size(); j++) {
					if (lottoNum.get(j) == num) {
						flag = false;
					}
				}
				if (flag) {
					lottoNum.add(num);
				} else {
					i--;
				}
			} else {
				lottoNum.add(num);
			}
		}
		Collections.sort(lottoNum);
		return lottoNum;
	}

	public ArrayList<Integer> lottoAll(String num1, String num2) {
		ArrayList<Integer> lottoNum = new ArrayList<>();
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
		lottoNum.add(this.num1);
		lottoNum.add(this.num2);
		for (int i = 0; i < 4; i++) {
			boolean flag = true;
			int num = (int) (Math.random() * 45 + 1);

			for (int j = 0; j < lottoNum.size(); j++) {
				if (lottoNum.get(j) == num) {
					flag = false;
				}
			}
			if (flag) {
				lottoNum.add(num);
			} else {
				i--;
			}

		}
		Collections.sort(lottoNum);

		return lottoNum;
	}

}
