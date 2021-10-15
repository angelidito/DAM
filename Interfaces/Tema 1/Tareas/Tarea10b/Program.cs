using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea10b
{
    class Program
    {
        static void Main(string[] args)
        {
            int n;
            do
            {
                Console.WriteLine("Escriba un nº del 1 al 12.");
                n = Int32.Parse(Console.ReadLine());

                switch (n)
                {
                    case 1:
                        Console.WriteLine("El mes nº " + n + " corresponde a enero.\n");
                        break;
                    case 2:
                        Console.WriteLine("El mes nº " + n + " corresponde a febrero.\n");
                        break;
                    case 3:
                        Console.WriteLine("El mes nº " + n + " corresponde a marzo.\n");
                        break;
                    case 4:
                        Console.WriteLine("El mes nº " + n + " corresponde a abril.\n");
                        break;
                    case 5:
                        Console.WriteLine("El mes nº " + n + " corresponde a mayo.\n");
                        break;
                    case 6:
                        Console.WriteLine("El mes nº " + n + " corresponde a junio.\n");
                        break;
                    case 7:
                        Console.WriteLine("El mes nº " + n + " corresponde a julio.\n");
                        break;
                    case 8:
                        Console.WriteLine("El mes nº " + n + " corresponde a agosto.\n");
                        break;
                    case 9:
                        Console.WriteLine("El mes nº " + n + " corresponde a septiembre.\n");
                        break;
                    case 10:
                        Console.WriteLine("El mes nº " + n + " corresponde a octubre.\n");
                        break;
                    case 11:
                        Console.WriteLine("El mes nº " + n + " corresponde a noviembre.\n");
                        break;
                    case 12:
                        Console.WriteLine("El mes nº " + n + " corresponde a diciembre.\n");
                        break;
                    default:
                        Console.WriteLine("Eso no es un mes... \n");
                        break;
                }

            } while (true);
        }
    }
}
