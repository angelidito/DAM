using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea4
{
    class Program
    {
        static void Main(string[] args)
        {
            int edad;

            Console.WriteLine("¿Qué edad tienes?");
            edad = Int32.Parse(Console.ReadLine());
            if (edad >= 18)
                Console.WriteLine("Eres mayor de edad");
            else
                Console.WriteLine("Eres menor de edad");
        }
    }
}
