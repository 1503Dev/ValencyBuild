namespace Valency.Lang.Interpreter
{
    public class Expression<T> : IExecutable<T>
    {
        public virtual T? Execute()
        {
            return default(T);
        }

        public T? ReturnType { get; set; }

    }

    public interface IExecutable<T>
    {
        public T Execute();
    }
}