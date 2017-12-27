package com.momoiropuchoman;

/**
 *	xとyで2次元座標を表すクラス．
 *	PlayerやSpriteなどのMap内での位置を表す．
 */

class Position {
	int x;
	int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 *	@param	object 	比較対象のPositionインスタンス
	 *	@return	同じ座標か	
	 */
	public boolean equals(Object object) {
		Position position = (Position)object;
		if(this.x == position.x && this.y == position.y) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *	@return	同じ座標なら同じ値	
	 */
	public int hashCode() {
		int code = 17;

		code *= 31;
		code += x;

		code *= 31;
		code += y;

		return code;
	}
}