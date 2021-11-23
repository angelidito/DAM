
using System;

namespace Terea9
{
    class Program
    {
        static void Main(string[] args)
        {
            double notaE;
            double notaB;

            Console.WriteLine("Indique su nota media de Bachillerato:");
            notaB = Double.Parse(Console.ReadLine());
            Console.WriteLine("Indique su nota media de la EVAU:");
            notaE = Double.Parse(Console.ReadLine());

            if (notaB >= 9 || notaE >= 9.5)
                Console.WriteLine("Usted SÍ tiene beca");
            else
                Console.WriteLine("Usted NO tiene beca");
        }
    }
}
