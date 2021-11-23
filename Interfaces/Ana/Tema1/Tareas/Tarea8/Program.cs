using System;

namespace Tarea8
{
    class Program
    {
        static void Main(string[] args)
        {
            int edad;

            Console.WriteLine("¿Qué edad tienes?");
            edad = Int32.Parse(Console.ReadLine());
            if (edad < 18)
                Console.WriteLine("Eres mayor de edad, no puedes conducir.");
            else
            {
                Console.WriteLine("¿Tienes carnet de conducir? s/n");
                char carnet = Console.ReadLine()[0];
                Console.Write("Eres mayor de edad");
                if (carnet == 's')
                    Console.WriteLine(" y puedes conducir.");
                else
                    Console.WriteLine(", pero no puedes conducir.");
            }
        }
    }
}
