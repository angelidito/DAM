using System;

namespace Tarea1
{
    class Program
    {
        static void Main(string[] args)
        {
            string entrada;
            int num1;
            int num2;
            int resultado;

            num1 = 5;
            Console.Write("Dame un número para sumarlo:");
            entrada = Console.ReadLine();

            num2 = Int32.Parse(entrada);

            resultado = num1 + num2;
            Console.WriteLine("El resultado es: {0}.", resultado);

            Console.WriteLine(6 == 6);

            Console.WriteLine(6 != 5);
            Console.WriteLine(5 != 5);


        }
    }
}
