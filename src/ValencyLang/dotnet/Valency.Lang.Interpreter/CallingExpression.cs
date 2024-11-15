using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Valency.Lang.Interpreter
{
    public class CallingExpression<T> : Expression<T>, IExecutable<T>
    {
        public CallingExpression() { }

        public override T? Execute()
        {
            
        }

        public static CallingExpression<T> Parse(String exp)
        {

        }
    }
}
