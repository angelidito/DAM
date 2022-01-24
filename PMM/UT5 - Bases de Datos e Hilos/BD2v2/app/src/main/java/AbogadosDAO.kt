import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.ammd.bd2v2.AbogadosDB

class AbogadosDAO(context: Context) {
	private val database: SQLiteDatabase

	companion object{
		val DB_NAME = "abogados"
		val DB_VERSION = 1
		val TABLE_USUARIOS = "usuarios"
		val TABLE_CASOS = "casos"
		val TABLE_GESTIONES = "gestiones"
	}

	init {
		val estructura = AbogadosDB(
			context,
			DB_NAME,
			factory = null,
			DB_VERSION)
		database = estructura.writableDatabase
	}
}