using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea10c
{
    class Program
    {
        static void Main(string[] args)
        {
            do
            {
                Console.WriteLine("¿Quieres saber si un número es par o impar?\n¡Dime cuál!");
                int n = Int32.Parse(Console.ReadLine());

                Console.Write("El número {0} es ", n);
                switch (n % 2)
                {
                    case 1:
                        Console.WriteLine("impar.\n");
                        break;
                    case 0:
                        Console.WriteLine("par.\n");
                        break;
                }

            } while (true);
        }
    }
}
