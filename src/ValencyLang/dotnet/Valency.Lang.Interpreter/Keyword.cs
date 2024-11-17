using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Valency.Lang.Interpreter
{
    public class Keyword
    {
        public static KeywordType GetKeyword(String keyword)
        {
            if (keyword is null)
            {
                throw new ArgumentNullException("keyword");
            }

            switch (keyword.ToLower())
            {
                case "function":
                    return KeywordType.Function;
                case "const":
                    return KeywordType.Const;
                default:
                    throw new NotImplementedException($"未定义标识符'{keyword}'");
                    
            }
        }

        public enum KeywordType
        {
            Const,Function
        }
    }
}
