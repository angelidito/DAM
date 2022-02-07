package com.example.pedropaexamenprueba

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.pedropaexamenprueba.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var telefono: String ="665355322"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val imagen: String = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxASERMOEBQRExEWEREQERkRFxERExgYFhIXGBYTFxkaKishGhsoHBYbIj8iKCstPDAwGSA1OjUuOSovMDIBCgoKDw4PHBERHDEmISE3LzUyLy04Ly8vLS85Ly8xLy8tLzEyMC8vLzkvMS8vNy8vLy80LS8vLy8vLy8vLy8vLf/AABEIALcBEwMBIgACEQEDEQH/xAAcAAEBAQEBAQEBAQAAAAAAAAAABQMEBgECBwj/xABIEAABAwECBwsJBQYHAQAAAAABAAIDBAUREhUhMTNT0QYTFEFRUoORkpOyIjJhcXKBoaOzNFRzgtJCQ0SxwcIHFiMkYuHwov/EABsBAQADAQEBAQAAAAAAAAAAAAACAwQBBQcG/8QAOhEAAgEBBAUJBgUFAQAAAAAAAAECAxETUVIEEpGS8BQhMTJBcYGx0TNigqHS4UJhcrLiIjSzwdND/9oADAMBAAIRAxEAPwD+4oiIAsjMwZC5vWFqvAOp4y+UljCeEVN5LWk6d6nCGsU1quok7D3e/M5zesJvzOc3rC8HwWPmR9lqcFj5kfZarblYlHKnl+f2Peb8znN6wm/M5zesLwfBY+ZH2WpwWPmR9lqXKxHKnl+f2Peb8znN6wm/M5zesLwfBY+ZH2WpwWPmR9lqXKxHKnl+f2Peb8znN6wm/M5zesLwfBY+ZH2WpwWPmR9lqXKxHKnl+f2Peb8znN6wm/M5zesLwfBY+ZH2WpwWPmR9lqXKxHKnl+f2Peb8znN6wtF/OaymjEbyGMBwTdc1q/oyrnDV7S+jVvLeaywIiKsuCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiALytfY8AmdcHjCG+OulmaMJ73lxuDrheeReqUW1NL0TPE9dTa6CMoqXSrSVimHmyd5P+pMUw81/eT/qXai7ryxe05dQyrYjixTDzX95P+pMUw81/eT/qXatIYHuysGTlPkt93GfcE15YvaLqGVbETsUw81/eT/qTFMPNf3k/6lbbZZ/acPyt/qT/AEX11lniePzNv/kQmvLF7Tl3TyrYiHimHmv7yf8AUmKYea/vJ/1KnNTSMyuF45W+UPfxj/2VYgpryxe07dQyrYjixTDzX95P+pMUw82TvJ/1LtRNeWL2i6hlWxHNR2LTvkDHNeW7291xknuvDmZxhZc69WotmaYfhSeONWlxyb6Tqil0IIiLhIIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAotqaXomeJ6tKLaml6JniegOdEX7p4sN4ZxZS72RnHvJA96A6aGjDhhu83iHEf+R9Ho/8ACsiID/O+6d5FXPl/fzcmtcpsUhwhl4xxBUN1H2uf8eb6rlNh84esLwKretLvZ9b0OKuKb92Pkf6OsX7NB+BF9MLKuos72D0uaOPlIHL/AD9a1sT7NB+BD9MLuXvnyQ86Dxotq2HAkIHmu8tvX5Q68v5ligOizNMPwpPHGrS87DWRxStdI8NBZI0X8Zwozcu/H9LrmfFdSeBFziullNFMx/S65nxTH9LrmfFNV4HLyOKKaKZj+l1zPimP6XXM+KarwF5HFFNFMx/S65nxTH9LrmfFNV4C8jiimimY/pdcz4pj+l1zPimq8BeRxRTRTMf0uuZ8Ux/S65nxTVeAvI4opopmP6XXM+KY/pdcz4pqvAXkcUU0UzH9LrmfFMf0uuZ8U1XgLyOKKaKZj+l1zPiuulqo5G4cbg5pJF7covBuI60aaOqUX0M6ERFwkEREAREQBRbU0vRM8T1aUW1NL0TPE9Ac67rIb5T3ehgHW4n+nUuFd1kO8p7fQwj/AOgf6daBn8KG6SuGThE3eS8vrT/MtZr5u8l2qYI3chzDi9Cb07kK/P3ksXtPrnI6GSOxCR5JLnEkkk8pJOck8ZX5BQhFE0RikrEVG7oqwANE8wAAAAfIAAMwGVfpu6SsvH+vNn1ku1S96dyHqX6ZE68ZDnUryWZ7TPyOhkjsR/cbJcXUVJI4uLiwAkkuJvBJvJz+aF0LmsY/7GjHHgB3uDXD+bguhe9HoR8nrKypLvfmTrU0kXsyf2LFVJ6eN9wkYx4GbDaHXeq9Y4tg1MXYZsWiFVRVlhhqaO5ycrTgRd+LYNTF2GbExbBqYuwzYpX6wIckeJwIu/FsGpi7DNiYtg1MXYZsS/WA5I8TgRd+LYNTF2GbExbBqYuwzYl+sByR4nAi78WwamLsM2Ji2DUxdhmxL9YDkjxOBF34tg1MXYZsTFsGpi7DNiX6wHJHicCLvxbBqYuwzYmLYNTF2GbEv1gOSPE4EXfi2DUxdhmxMWwamLsM2JfrAckeJwr0G5fQdLL9Qqbi2DUxdhmxVtzsbWwYLQGgS1FwaABp38QUZ1FJWFlKg4StbKqIipNIREQBERAFFtTS9EzxPVpRbU0vRM8T0BzrWmmwHh5zZWu9R4/cQD6r1kiAp4npdRB3cexMT0uog7uPYsqGtAuY45MzCfg07fdnz1EB/nTdKwCqnaAABPKABkAAkdcAFOh84esKnumaeFz5Dp5vqOU6JhwhkOcL8/V60u9n1zQ/YU/0x8j+/WPZNMaeAmCAkwxEkxxk+YMuZduJ6XUQd3HsX2xfs0H4EP0wvxXVt18bDlzOI/Z9A/5fyX6A+R2nHU4OFgsAaxg3tgaAAMvlXAZsuT8qyQDiRAEJuynNnKLKt0Un4b/CUB939nOb1hfOEM5zesKPYlhU8tOyV7XFxw77nOGZ5Gb3Lpfucpua7tOWydClGTi5vm93+R5lPTK84KapxsaT6z7fgO/f2c5vWF94QznN6wpD7Bpua7tOXJV2RE1ri0G8AkZXcQXVo9JuzXe7/IS0yvFNunHm95/Qel3xt2FeLuW8XZ7l+N/Zzm9YUpv2D8p+qV+6Pc9TOjjeWuwnMa53lOGUgEquNCNjcpNWOzmVv+0XT0mpbFQinaredteUXb8ijwhnOb1hOEM5zesKe/c7S813acsH2DT813acpXNLO9i+orelV1/5x3n9BX4QznN6wv2Xi7CvF2TLeLsubKvK2pZcUcTntDgRddlcc7rv6qraR/2Q9iDxMXJ6PFaurK3WdnOrLOj83iSpaZN6+vBLVWtzO23rfkrOr+ZT39nOb1hfOEM5zesLhp9zlK6Njy117mNcfKdnIBK/L9ztLzXdpy66NJOzXexfUc5TpHTdx3n/AMyjv7Oc3rC+7+znN6woz7Bp+a7tOU61bMjjjc9mECC27ynHO4BTho1KclFTfP7v8imrp9anBzdOPMm+s+z4D1oN+UZlQsDQ9LUfXepdNo2ewzwhVLA0PS1H1nrCesUkREAREQBERAFFtTS9EzxPVpRbU0vRM8T0BzoiIAtIal7MjTe3kdlHu4x/L0LNEBzusyiJc59JGSXFzsENdeSbyTfdlvKOsug/ZpI7/wDkAB8L10Io6qwLL2eZ7Wamd+CGC5jAA0NZeMgFwF+fquWQHEiKRWEREAWVdopPw3+ErVZ1LC5j2jOWOaPWWkIDHcz9li9T/qOXXIoNm1NZFG2EU2Fg35d8jF97ieX0rZ1fWH+F+ZHtXo1qetUlJONjbfWjj3njaPV1aMIuMrUkurPsSWB3SLgr/Mf7Dv5FZuqq0/w3zI9qxnNW8OZwci8FukZxj1pCnY1a470fU5UqWxdkZbsvQ6B9h/KfqlWbO0EP4UfhCmtpH8E3nB8vBPk3jn33X5llT11Y1jY+DX4ADb98jF+CAL8/oUEtdSSa6z6WlzeLRok3BxbT6qXMm+fB2LmLEi5ZFxOr6w/wvzI9qydVVh/hvmR7UVJrtjvR9SuVb3Zbk/Qzt3QP/L4wum0vsQ9iDxMU+tZVyMMfByL7suHGcxB5fQq1bSvdS700XvwIhdeM7S28XnJxKU2o3abXNK3pTy4W4EaUZSdZ6r54JK1NWv8Ar6LUsUVKPQx/hs8IWcilQ2hWNaGcFvwWht++R5bgBfn9C/Lq6sP8L8yPaoOk7Xzx3o+pZfKxf0y3J+h3yKPb2hd62+ILV1VWH+G+ZHtXJXR1kjCwwEX3ZcOM5jfyq+hHVqRba5mvxRx7zJpUnOlOMYStaa6ssO49HTaNnsM8IVSwND0tR9Z6mwNIY1pzhrQfcFSsDQ9LUfWevLPffSUkREAREQBERAFFtTS9EzxPVpRbU0vRM8T0BzoiIAiIgCIiAKbZduU9Rv4heXbxI6GbyXtwXtvvGUZcxyhUgv5HuSs+ulltV1LVtpmCunEjTBHPhHCflvdmyZEB/RKXdRRSUptBswFM0uBe8PYLwbrrnC8m83XXZeJTbJ/xDsyombBFPdI44LN8Y+MOJNwaC4XXnkN16/mMcLjYNHK5jpKeK0XyVTW5yzCuvPoykfmCu/4iW5ZtZSwUtBgzVTpY+DCFhY+McYOQYIuyYPqPFegPebod2VBQvbFUylsjm4Yaxr5HBvOdg5hkPUvlq7tKCmZDLNKWMnj32E73McJtzTfcBeMjhnuzrxW7d8cFXJXQWgyC0YqSNs0UjQ8SjABDGk5MJwaPJuOdpyX3rmtq0aupmsKpjbDHVSMmcwSB4gv8kBxDfKDS0X3DlCA98zdrZzqZ1c2YGBj2xvcGSYTXONwBZdhC/wBS57S/xDsuCV0E0xbI3BwhvUzrsJocMobdmIXhd1G5eejsy0KipfE+eqqoJZBAHCJt0riA28A5TIeLk9aq7vgOG7n82Wobf3lKgPbV+6ijhpo66WXBgkEZjdgvJdhtwm3NAwr7gTm4lrUW/TMpMYPf/tsCOTDDXu8mQtDTggYWdwyXZF/Pf8Q6zhFpU9niCapgpmGoqYqcYby548kEcQALOP8AeFR6O0X/AOX7Rs+YOZLSviaGyAteI5KqNzQQeMOwusID+zUVUyWKOaM3xyRsljNxF7XtDmm45RkIWy8xuAtqmmo6eGGVkkkNJTNla2+9hETWkH3gj3L06AIiIAiIgCIiAIiIAqFgaHpaj671PVCwND0tR9d6ApIiIAiIgCIiAKLaml6JnierSi2ppeiZ4noDnXy8L6octmOw3uMMb75HuBJZeQXEi+8KUYp9LsK6k3FcytLmEOUJhDlCg4rOoi+XsTFZ1EXy9indxzcbSu+qZHx4F7CHKEwhyhQcWHURfL2Jis6iL5exLuObjaL6pkfHgXsIcoWUUETMLAbG3COE/BDW4RPG67OfWo2KzqIvl7ExWdRF8vYl3HNxtOX1TI+PAswwRMbvbGxtZlva0Na3LnyDIuaisikhcZIYaeJ5zuijijcb+UtF6n4rOoi+XsTFZ1EXy9iXcc3G0X1TI+PApVlmU0zmvnhglc3zTLHHI4eouF4W74InOa9zYy5vmEhpc32TnHuUbFZ1EXy9iYrOoi+XsS7jm42i+qZHx4FqeKORuBI1j25yHhrm5M2Qr5JTxOLXOZG4sN8Zc1pLTkytJ83MM3IFGxWdRF8vYmKzqIvl7Eu45uNp2+qZHx4FlkETXOka2MPd57gGhzvaIylfh9FC4uc6OEl4AeSxhLgCCA48eUDPyBScVnURfL2Jis6iL5exLuObjacvqmR8eBXpqSGO8xRxRk5DvbWMv9d2db4Q5QoOKzqIvl7ExWdRF8vYl3HNxtF9UyPjwL2EOUJhDlCg4rOoi+XsTFZ1EXy9iXcc3G0X1TI+PAvYQ5QmEOUKDis6iL5exfioshzmOaIIgS1wBvjyEi4HMl3HNxtDrVMj48D0KIiqNIREQBULA0PS1H13qeqFgaHpaj670BSREQBERAEREAUW1NL0TPE9WlFtTS9EzxPQHOiIgP0F52yqWpna54qHMAdg3EX5gDf8V6Fqn7kdC/2/7WrVQerCcrF2dKTxxTMWlR1pwja0v6uhtdiwaMTZFV97PZO1fk2VVfej2TtXoHLNynfSwjux9Cjk0c0t+f1EE2ZVfeXdk7V+DZ9V95d2TtVtyzcuqs8I7sfQjyeOaW/P1Ixoqr7y7q/7X5NLVfeXdSrOWTlK9eEd2PoV3KzS35+pLMFV94d1LkqKyoj30GZ7i1jLjmyl8YPwJ61ZcoNqedUexH9SNX0GpyscY9n4Y5o/kZ9IUqcHKMpdEvxSf4JvHFJl2OyKota7hZytDvNPGL+VfTZFV97PZO1XKfRt9hvhC+uWW+lhHdj6HoPRo5pb9T6jz5sqq+8nsnavybNqvvLuz/2rrlk5dvnhHdj6Fb0eOaW/P1IpoKr7y7q/7X5NHVfeXdSruWbl29eEd2PoRdBZpb8/qJJpqr7w7qX4dDVj9+7qVRyxlzH1FSvXhHdj6ELn3pb8/qNdz075IA95LnYTspz51RUnct9mb7T1WWTSUlWmli/NnpaFJy0enJ87cY+SCIipNIREQBULA0PS1H13qeqFgaHpaj670BSREQBERAEREAUW1NL0TPE9WlFtTS9EzxPQHOiIgPrVP3I6F/t/2tVBqn7kdC/2/wC1q0UvZz+HzZkr+0h8Xkiw5ZuWjlm5Dhi5ZuWjlm5dRWZOWTlq5ZOUytmLlBtTzqj2I/qRq85QbU86o9iP6ka1aL19398TFpvs33T/AMcz3VPo2+w3whfXL5T6NvsN8IX1ywdrPXfQZOWTlq5ZOXStmTlm5aOWblMrZk5YSZj6it3LCTMfUVJFbPu5b7M32nqspO5b7M32nqsqdK9vPvl5s16B/a0v0x/agiIqDWEREAVCwND0tR9d6nqhYGh6Wo+u9AUkREAREQBERAFFtTS9EzxPVpQbXmY2XynNbfEy7CIbfc5991/rQGaLHhkWsj7TU4ZFrI+01AbtU/cjoX+3/a1dLayLWR9pqmblLRgETw6aIHD43sH7LfStFL2c/DzZkr+0h8X+j0Tlm5YOtOn10HeR7Vk606fXQd5HtXLTjNnLNyxdacGug7yPasnWlBroe8j2qSIGzlk5ZOtKDXQ95HtWbrRg10PeR7VK0qZ+3KDannVHsR/UjVV1o0+uh7bNqhWjXQl1RdJCfIZmew/vI/StWi9fd/fExaandvun/jmf0Kn0bfYb4QvrlyU9p0+9t/1oPNb+8j5o9KOtOn10HeR7Vh7T12bOWTli606fXQ95HtWTrTg10HeR7V0rZs5ZuWLrSg10PeR7Vk60oNdD3ke1StK2bOWMmY+orN1owa6HvI9qwltGC4/6sOY/ts2qZBnXuW+zN9p6rKHuXq4uDt/1I/Of+03lVbhkWsj7TVTpXtp/ql5s16D/AG1L9Mf2o2RY8Mi1kfaanDItZH2mqg1GyLHhkWsj7TU4ZFrI+01AbKhYGh6Wo+u9SeGRayPtNVXc+QYbxlBlnIuzXGZ9xQFNERAEREAREQBERAEREAXxEQC5LkRALkuREAuS5EQC5fURBafLkuREAuS5EQC5LkRALkuREB9REQBERAEREAREQBERAEREB//Z"
        Glide.with(binding.root)
            .load(imagen)
            .centerCrop()
            .into(binding.imagen)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.aceptar.setOnClickListener {
            intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
        binding.llamar.setOnClickListener {
            onClickLlamar()
        }
    }

    fun onClickLlamar() {
        // Si el permiso no está aceptado
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Muestra el mensaje explicando el permiso
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE)
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Permiso Necesario")
                builder.setMessage("Este permiso sirve para realizar llamadas \nDebe ser aceptado")
                // Si aceptas el mensaje se muestra la ventana propia de aceptar el permiso
                builder.setPositiveButton("Aceptar") {
                        _, _ -> ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 123)
                }
                // Si cancelas el permiso se cierra esa ventana
                builder.setNegativeButton("Cancelar", null)
                builder.show()
            }
            // Se muestra la ventana propia de aceptar el permiso
            else {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 123)
            }
        }
        // Si el permiso ya estaba concedido, llama al método de realizar la llamada
        else {
            llamada()
        }
    }
    private fun llamada() {
        //El "tel:" sirve para que pille el número de teléfono correctamente
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono))
        startActivity(intent)
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            123 -> {
                // Si aceptas el permiso
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamada()
                }
                // Si cancelas el permiso
                else
                    Snackbar.make(binding.root, "Permiso no concedido :(", Snackbar.LENGTH_LONG).show()
            }
            else -> Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG).show()
        }
    }

}