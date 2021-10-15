using System;

namespace Tarea6
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

                    Console.Write("Resultado: ");
                    if (opt == 1)
                        Console.WriteLine(a + " + " + b + " = " + (a + b));
                    else
                    {
                        if (opt == 2)
                            Console.WriteLine(a + " - " + b + " = " + (a - b));
                        else
                        {
                            if (opt == 3)
                                Console.WriteLine(a + " * " + b + " = " + (a * b));
                            else
                            {
                                if (opt == 4)
                                    Console.WriteLine(a + " / " + b + " = " + (a / b));
                                else
                                {
                                    if (opt == 5)
                                        Console.WriteLine(a + " % " + b + " = " + (a % b));
                                }
                            }
                        }
                    }
                }
                Console.WriteLine();
            } while (opt != 0);
        }
    }
}
