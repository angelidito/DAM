
using System;

namespace Tarea10a
{
    class Program
    {
        static void Main(string[] args)
        {
            int opt, a, b;
            do
            {
                do
                {
                    Console.WriteLine("Escoja una opción: ");
                    Console.WriteLine("\t1. Suma.\n"
                                    + "\t2. Resta.\n"
                                    + "\t3. Multiplicación.\n"
                                    + "\t4. División.\n"
                                    + "\t5. Módulo.\n"
                                    + "\t0. Salir.");

                    opt = Int32.Parse(Console.ReadLine());
                } while (opt < 0 || opt > 5);

                if (opt != 0)
                {
                    Console.WriteLine("Escriba el primer nº: ");
                    a = Int32.Parse(Console.ReadLine());
                    Console.WriteLine("Escriba el segundo nº: ");
                    b = Int32.Parse(Console.ReadLine());
                }
                Console.Write("Resultado: ");
                switch (opt)
                {
                    case 1:
                        Console.WriteLine(a + " + " + b + " = " + (a + b));
                        break;
                    case 2:
                        Console.WriteLine(a + " - " + b + " = " + (a - b));
                        break;
                    case 3:
                        Console.WriteLine(a + " * " + b + " = " + (a * b));
                        break;
                    case 4:
                        Console.WriteLine(a + " / " + b + " = " + (a / b));
                        break;
                    case 5:
                        Console.WriteLine(a + " % " + b + " = " + (a % b));
                        break;
                    case 0:
                        Console.WriteLine("¡Adiós!");
                        break;
                    default:
                        Console.WriteLine("Error inesperado");
                        break;
                }
                Console.WriteLine();

            } while (opt != 0);
        }
    }
}
