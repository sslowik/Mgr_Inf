namespace FactoryPattern
{
    using System;

    /// <summary>
    /// Singleton with double-checked locking (thread-safe).
    /// </summary>
    /// <typeparam name="T">Singleton Type.</typeparam>
    public abstract class GenericSingleton<T> where T: class
    {
        private static T instance;

        private static readonly object ctorLock = new object();

        public static T Instance
        {
            get
            {
                if (instance == null)
                {
                    lock (ctorLock)
                    {
                        if (instance == null)
                        {
                            instance = Activator.CreateInstance(typeof(T), true) as T;
                        }
                    }
                }

                return instance;
            }
        }
    }
}
