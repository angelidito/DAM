using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tarea18
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal grad;

            grad = 37;
            Console.WriteLine("{0}º son {1] rad", grad, GradToRad(grad));
        
            grad = 45;
            Console.WriteLine("{0}º son {1] rad", grad, GradToRad(grad));
        
            grad = 180;
            Console.WriteLine("{0}º son {1] rad", grad, GradToRad(grad));
        
            grad = 360;
            Console.WriteLine("{0}º son {1] rad", grad, GradToRad(grad));
        }

        static decimal GradToRad(decimal grad)
        {
            return grad * Math.PI * 180;
        }
    }
}
