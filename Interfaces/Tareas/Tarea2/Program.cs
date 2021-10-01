using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea2
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.Write("Introduce un número: ");
            double n = Double.Parse(Console.ReadLine());
            if (n > 0)
                Console.WriteLine("El número es positivo");
            else if (n < 0)
                Console.WriteLine("El número es negativo");

        }
    }
}
