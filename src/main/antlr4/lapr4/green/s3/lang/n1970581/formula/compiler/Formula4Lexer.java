// Generated from C:\enginfo\BitBucket repo\lapr4-2017-2dl\src\main\antlr4\lapr4\green\s3\lang\n1970581\formula\compiler\Formula4.g4 by ANTLR 4.4

    package lapr4.green.s3.lang.n1970581.formula.compiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Formula4Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TEMPORARY=1, GLOBAL=2, FUNCTION=3, CELL_REF=4, STRING=5, QUOT=6, NUMBER=7, 
		EQ=8, NEQ=9, LTEQ=10, GTEQ=11, GT=12, LT=13, AMP=14, PLUS=15, MINUS=16, 
		MULTI=17, DIV=18, POWER=19, PERCENT=20, COLON=21, UNDSCR=22, ARROBA=23, 
		COMMA=24, SEMI=25, LPAR=26, RPAR=27, L_CURLY_BRACKET=28, R_CURLY_BRACKET=29, 
		ASSIGN=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'"
	};
	public static final String[] ruleNames = {
		"LETTER", "TEMPORARY", "GLOBAL", "FUNCTION", "CELL_REF", "STRING", "QUOT", 
		"NUMBER", "DIGIT", "EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", "PLUS", 
		"MINUS", "MULTI", "DIV", "POWER", "PERCENT", "ABS", "EXCL", "COLON", "UNDSCR", 
		"ARROBA", "COMMA", "SEMI", "LPAR", "RPAR", "L_CURLY_BRACKET", "R_CURLY_BRACKET", 
		"ASSIGN", "WS"
	};


	public Formula4Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formula4.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00c7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\3\6\3O\n\3\r\3\16\3P\3\4\3\4"+
		"\3\4\6\4V\n\4\r\4\16\4W\3\5\6\5[\n\5\r\5\16\5\\\3\6\5\6`\n\6\3\6\3\6\5"+
		"\6d\n\6\3\6\5\6g\n\6\3\6\6\6j\n\6\r\6\16\6k\3\7\3\7\3\7\3\7\7\7r\n\7\f"+
		"\7\16\7u\13\7\3\7\3\7\3\b\3\b\3\t\6\t|\n\t\r\t\16\t}\3\t\3\t\6\t\u0082"+
		"\n\t\r\t\16\t\u0083\5\t\u0086\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3#\3$\3$\3$\3$\5$\u00c4\n$\3$\3$\2\2%\3\2\5\3\7\4\t\5\13\6\r\7"+
		"\17\b\21\t\23\2\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24"+
		"+\25-\26/\2\61\2\63\27\65\30\67\319\32;\33=\34?\35A\36C\37E G!\3\2\4\4"+
		"\2C\\c|\3\2$$\u00d2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5K\3\2\2\2\7R\3"+
		"\2\2\2\tZ\3\2\2\2\13_\3\2\2\2\rm\3\2\2\2\17x\3\2\2\2\21{\3\2\2\2\23\u0087"+
		"\3\2\2\2\25\u0089\3\2\2\2\27\u008b\3\2\2\2\31\u008e\3\2\2\2\33\u0091\3"+
		"\2\2\2\35\u0094\3\2\2\2\37\u0096\3\2\2\2!\u0098\3\2\2\2#\u009a\3\2\2\2"+
		"%\u009c\3\2\2\2\'\u009e\3\2\2\2)\u00a0\3\2\2\2+\u00a2\3\2\2\2-\u00a4\3"+
		"\2\2\2/\u00a6\3\2\2\2\61\u00a8\3\2\2\2\63\u00aa\3\2\2\2\65\u00ac\3\2\2"+
		"\2\67\u00ae\3\2\2\29\u00b0\3\2\2\2;\u00b2\3\2\2\2=\u00b4\3\2\2\2?\u00b6"+
		"\3\2\2\2A\u00b8\3\2\2\2C\u00ba\3\2\2\2E\u00bc\3\2\2\2G\u00c3\3\2\2\2I"+
		"J\t\2\2\2J\4\3\2\2\2KN\5\65\33\2LO\5\21\t\2MO\5\3\2\2NL\3\2\2\2NM\3\2"+
		"\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\6\3\2\2\2RU\5\67\34\2SV\5\21\t\2T"+
		"V\5\3\2\2US\3\2\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\b\3\2\2\2"+
		"Y[\5\3\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\n\3\2\2\2^`\5/"+
		"\30\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ac\5\3\2\2bd\5\3\2\2cb\3\2\2\2cd\3"+
		"\2\2\2df\3\2\2\2eg\5/\30\2fe\3\2\2\2fg\3\2\2\2gi\3\2\2\2hj\5\23\n\2ih"+
		"\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\f\3\2\2\2ms\5\17\b\2no\7^\2\2"+
		"or\7$\2\2pr\n\3\2\2qn\3\2\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2"+
		"tv\3\2\2\2us\3\2\2\2vw\5\17\b\2w\16\3\2\2\2xy\7$\2\2y\20\3\2\2\2z|\5\23"+
		"\n\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0085\3\2\2\2\177\u0081"+
		"\59\35\2\u0080\u0082\5\23\n\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\177"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\22\3\2\2\2\u0087\u0088\4\62;\2\u0088"+
		"\24\3\2\2\2\u0089\u008a\7?\2\2\u008a\26\3\2\2\2\u008b\u008c\7>\2\2\u008c"+
		"\u008d\7@\2\2\u008d\30\3\2\2\2\u008e\u008f\7>\2\2\u008f\u0090\7?\2\2\u0090"+
		"\32\3\2\2\2\u0091\u0092\7@\2\2\u0092\u0093\7?\2\2\u0093\34\3\2\2\2\u0094"+
		"\u0095\7@\2\2\u0095\36\3\2\2\2\u0096\u0097\7>\2\2\u0097 \3\2\2\2\u0098"+
		"\u0099\7(\2\2\u0099\"\3\2\2\2\u009a\u009b\7-\2\2\u009b$\3\2\2\2\u009c"+
		"\u009d\7/\2\2\u009d&\3\2\2\2\u009e\u009f\7,\2\2\u009f(\3\2\2\2\u00a0\u00a1"+
		"\7\61\2\2\u00a1*\3\2\2\2\u00a2\u00a3\7`\2\2\u00a3,\3\2\2\2\u00a4\u00a5"+
		"\7\'\2\2\u00a5.\3\2\2\2\u00a6\u00a7\7&\2\2\u00a7\60\3\2\2\2\u00a8\u00a9"+
		"\7#\2\2\u00a9\62\3\2\2\2\u00aa\u00ab\7<\2\2\u00ab\64\3\2\2\2\u00ac\u00ad"+
		"\7a\2\2\u00ad\66\3\2\2\2\u00ae\u00af\7B\2\2\u00af8\3\2\2\2\u00b0\u00b1"+
		"\7.\2\2\u00b1:\3\2\2\2\u00b2\u00b3\7=\2\2\u00b3<\3\2\2\2\u00b4\u00b5\7"+
		"*\2\2\u00b5>\3\2\2\2\u00b6\u00b7\7+\2\2\u00b7@\3\2\2\2\u00b8\u00b9\7}"+
		"\2\2\u00b9B\3\2\2\2\u00ba\u00bb\7\177\2\2\u00bbD\3\2\2\2\u00bc\u00bd\7"+
		"<\2\2\u00bd\u00be\7?\2\2\u00beF\3\2\2\2\u00bf\u00c4\7\"\2\2\u00c0\u00c1"+
		"\7\17\2\2\u00c1\u00c4\7\f\2\2\u00c2\u00c4\4\13\f\2\u00c3\u00bf\3\2\2\2"+
		"\u00c3\u00c0\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6"+
		"\b$\2\2\u00c6H\3\2\2\2\22\2NPUW\\_cfkqs}\u0083\u0085\u00c3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}