using System;

namespace Tarea12
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Quiero hallar el factorial de ");
            int n = Convert.ToInt32(Console.ReadLine());

            int factorial = 1;

            if (n < 0)
                factorial = 0;
            else if (n != 0)
                for (int i = 1; i <= n; i++)
                    factorial *= i;

            Console.WriteLine("\nEl resultado es {0}.\n", factorial);
        }
    }
}
