package mainfiles;


/**
* mainfiles/HangmanHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from mainfiles.idl
* Tuesday, May 1, 2018 7:12:39 PM PHT
*/

abstract public class HangmanHelper
{
  private static String  _id = "IDL:mainfiles/Hangman:1.0";

  public static void insert (org.omg.CORBA.Any a, mainfiles.Hangman that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static mainfiles.Hangman extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (mainfiles.HangmanHelper.id (), "Hangman");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static mainfiles.Hangman read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HangmanStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, mainfiles.Hangman value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static mainfiles.Hangman narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof mainfiles.Hangman)
      return (mainfiles.Hangman)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      mainfiles._HangmanStub stub = new mainfiles._HangmanStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static mainfiles.Hangman unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof mainfiles.Hangman)
      return (mainfiles.Hangman)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      mainfiles._HangmanStub stub = new mainfiles._HangmanStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
