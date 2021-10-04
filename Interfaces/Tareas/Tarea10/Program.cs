using System;

namespace Tarea10
{
    class Program
    {
        static void Main(string[] args)
        {
            bool izq = false, drch = false, puedeDespegar = false;
            int nivel;

            Console.WriteLine("¿Funciona su propulsor izquierdo? true/false");
            izq = Convert.ToBoolean(Console.ReadLine());

            Console.WriteLine("¿Funciona su propulsor derecho? true/false");
            drch = Convert.ToBoolean(Console.ReadLine());

            if (izq || drch)
            {
                Console.WriteLine("¿Cuál es el nivel de su tanque de combustible? Del 0 al 100");
                nivel = Convert.ToInt32(Console.ReadLine());
                if (nivel == 100)
                    puedeDespegar = true;
                else if (nivel >= 75 && izq && drch)
                    puedeDespegar = false;
            }

            if (puedeDespegar)
                Console.WriteLine("Puede despegar");
            else
                Console.WriteLine("No puede despegar");

        }
    }
}
