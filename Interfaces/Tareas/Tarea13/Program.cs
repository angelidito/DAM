using System;

namespace Tarea13
{
    class Program
    {
        static void Main(string[] args)
        {
            string pass = "";
            string confirm = " ";
            Console.WriteLine("Escriba su contraseña:");
            pass = Console.ReadLine();
            while (pass != confirm)
            {
                Console.WriteLine("Confirme su contraseña:");
                confirm = Console.ReadLine();
            }
            Console.WriteLine("OK");
        }
    }
}
