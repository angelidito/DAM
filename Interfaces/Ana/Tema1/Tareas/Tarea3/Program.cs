using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea3
{
    class Program
    {
        static void Main(string[] args)
        {

            double a, b;
            Console.WriteLine("Introduce el dividendo:");
            a = Double.Parse(Console.ReadLine());
            Console.WriteLine("Introduce el divisor:");
            b = Double.Parse(Console.ReadLine());
            Console.WriteLine("Resultado: " + a / b);
        }
    }
}
