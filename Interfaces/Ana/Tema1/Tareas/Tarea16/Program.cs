using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea16
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("¿Qué nº quiere elevar?");
            int n = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("¿A qué potencia desea elevarlo?");
            int p = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine(Math.Pow(n, p));
        }
    }
}
