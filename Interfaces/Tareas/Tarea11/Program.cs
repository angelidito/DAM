using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea11
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("¿Cuántos alumnos hay?");

            double n = Convert.ToInt32(Console.ReadLine());

            double sum = 0;

            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("Nota del alumnos nº {0}:", i + 1);
                sum = sum + Convert.ToDouble(Console.ReadLine());
            }

            Console.WriteLine("{0} / {1} = {2}", sum, n, (sum / n));
            Console.WriteLine("La media es de {0}.", (sum / n));
        }
    }
}
