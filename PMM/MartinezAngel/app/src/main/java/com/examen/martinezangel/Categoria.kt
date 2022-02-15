package com.ammd.martinezangel

import android.os.Parcel
import android.os.Parcelable


data class Categoria(var codigoCategoria: Int, var denominacion: String?): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readInt(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeInt(codigoCategoria)
		parcel.writeString(denominacion)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Categoria> {
		override fun createFromParcel(parcel: Parcel): Categoria {
			return Categoria(parcel)
		}

		override fun newArray(size: Int): Array<Categoria?> {
			return arrayOfNulls(size)
		}
	}


}
