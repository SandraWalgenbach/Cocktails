import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "drinks")
data class Drink (

    @PrimaryKey
    @Json(name = "idDrink")
    val id: Long,

    @Json(name = "strDrink")
    val name: String,

    @Json(name = "strDrinkThumb")
    val picture: String,

    var liked: Boolean = false
)
