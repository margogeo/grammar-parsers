// Generated from C:/Users/Rita/lab4/src\Grammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ARG=5, JAVA_CODE=6, NTERM=7, TERM=8, REGEX=9, 
		WS=10;
	public static final int
		RULE_start = 0, RULE_rules = 1, RULE_nTerm = 2, RULE_term = 3, RULE_opts = 4, 
		RULE_opt = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "rules", "nTerm", "term", "opts", "opt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'returns'", "':'", "';'", "'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ARG", "JAVA_CODE", "NTERM", "TERM", "REGEX", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<RulesContext> rules() {
			return getRuleContexts(RulesContext.class);
		}
		public RulesContext rules(int i) {
			return getRuleContext(RulesContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				rules();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NTERM || _la==TERM );
			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RulesContext extends ParserRuleContext {
		public NTermContext nTerm() {
			return getRuleContext(NTermContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRules(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rules);
		try {
			setState(21);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NTERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				nTerm();
				}
				break;
			case TERM:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NTermContext extends ParserRuleContext {
		public NTerm ntr;
		public Token NTERM;
		public Token ARG;
		public OptsContext opts;
		public TerminalNode NTERM() { return getToken(GrammarParser.NTERM, 0); }
		public OptsContext opts() {
			return getRuleContext(OptsContext.class,0);
		}
		public List<TerminalNode> ARG() { return getTokens(GrammarParser.ARG); }
		public TerminalNode ARG(int i) {
			return getToken(GrammarParser.ARG, i);
		}
		public NTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNTerm(this);
		}
	}

	public final NTermContext nTerm() throws RecognitionException {
		NTermContext _localctx = new NTermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			((NTermContext)_localctx).NTERM = match(NTERM);
			((NTermContext)_localctx).ntr =  new NTerm((((NTermContext)_localctx).NTERM!=null?((NTermContext)_localctx).NTERM.getText():null));
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARG) {
				{
				setState(25);
				((NTermContext)_localctx).ARG = match(ARG);
				_localctx.ntr.inhArg = (((NTermContext)_localctx).ARG!=null?((NTermContext)_localctx).ARG.getText():null);
				}
			}

			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(29);
				match(T__0);
				setState(30);
				((NTermContext)_localctx).ARG = match(ARG);
				_localctx.ntr.synthArg = (((NTermContext)_localctx).ARG!=null?((NTermContext)_localctx).ARG.getText():null);
				}
			}

			setState(34);
			match(T__1);
			setState(35);
			((NTermContext)_localctx).opts = opts();
			_localctx.ntr.opts = ((NTermContext)_localctx).opts.optionals;
			setState(37);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public Term tr;
		public Token TERM;
		public Token REGEX;
		public TerminalNode TERM() { return getToken(GrammarParser.TERM, 0); }
		public TerminalNode REGEX() { return getToken(GrammarParser.REGEX, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((TermContext)_localctx).TERM = match(TERM);
			setState(40);
			match(T__1);
			setState(41);
			((TermContext)_localctx).REGEX = match(REGEX);
			setState(42);
			match(T__2);
			((TermContext)_localctx).tr =  new Term((((TermContext)_localctx).TERM!=null?((TermContext)_localctx).TERM.getText():null), (((TermContext)_localctx).REGEX!=null?((TermContext)_localctx).REGEX.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptsContext extends ParserRuleContext {
		public ArrayList<ArrayList<Opt>> optionals;
		public OptContext opt;
		public List<OptContext> opt() {
			return getRuleContexts(OptContext.class);
		}
		public OptContext opt(int i) {
			return getRuleContext(OptContext.class,i);
		}
		public OptsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOpts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOpts(this);
		}
	}

	public final OptsContext opts() throws RecognitionException {
		OptsContext _localctx = new OptsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_opts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((OptsContext)_localctx).optionals =  new ArrayList<>();
			setState(46);
			((OptsContext)_localctx).opt = opt();
			_localctx.optionals.add(((OptsContext)_localctx).opt.lst);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(48);
				match(T__3);
				setState(49);
				((OptsContext)_localctx).opt = opt();
				_localctx.optionals.add(((OptsContext)_localctx).opt.lst);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptContext extends ParserRuleContext {
		public ArrayList<Opt> lst;
		public Token JAVA_CODE;
		public Token NTERM;
		public Token ARG;
		public Token TERM;
		public List<TerminalNode> JAVA_CODE() { return getTokens(GrammarParser.JAVA_CODE); }
		public TerminalNode JAVA_CODE(int i) {
			return getToken(GrammarParser.JAVA_CODE, i);
		}
		public List<TerminalNode> NTERM() { return getTokens(GrammarParser.NTERM); }
		public TerminalNode NTERM(int i) {
			return getToken(GrammarParser.NTERM, i);
		}
		public List<TerminalNode> TERM() { return getTokens(GrammarParser.TERM); }
		public TerminalNode TERM(int i) {
			return getToken(GrammarParser.TERM, i);
		}
		public List<TerminalNode> ARG() { return getTokens(GrammarParser.ARG); }
		public TerminalNode ARG(int i) {
			return getToken(GrammarParser.ARG, i);
		}
		public OptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOpt(this);
		}
	}

	public final OptContext opt() throws RecognitionException {
		OptContext _localctx = new OptContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_opt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((OptContext)_localctx).lst =  new ArrayList<>();
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				Opt o;
				setState(69);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case JAVA_CODE:
					{
					setState(59);
					((OptContext)_localctx).JAVA_CODE = match(JAVA_CODE);
					o = new Opt((((OptContext)_localctx).JAVA_CODE!=null?((OptContext)_localctx).JAVA_CODE.getText():null), 0);
					}
					break;
				case NTERM:
					{
					setState(61);
					((OptContext)_localctx).NTERM = match(NTERM);
					o = new Opt((((OptContext)_localctx).NTERM!=null?((OptContext)_localctx).NTERM.getText():null), 1);
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ARG) {
						{
						setState(63);
						((OptContext)_localctx).ARG = match(ARG);
						o.arg = (((OptContext)_localctx).ARG!=null?((OptContext)_localctx).ARG.getText():null);
						}
					}

					}
					break;
				case TERM:
					{
					setState(67);
					((OptContext)_localctx).TERM = match(TERM);
					o = new Opt((((OptContext)_localctx).TERM!=null?((OptContext)_localctx).TERM.getText():null), 2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				_localctx.lst.add(o);
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JAVA_CODE) | (1L << NTERM) | (1L << TERM))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\fO\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\2\3\2"+
		"\3\3\3\3\5\3\30\n\3\3\4\3\4\3\4\3\4\5\4\36\n\4\3\4\3\4\3\4\5\4#\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6\67\n\6\f\6\16\6:\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7D\n\7\3"+
		"\7\3\7\5\7H\n\7\3\7\6\7K\n\7\r\7\16\7L\3\7\2\2\b\2\4\6\b\n\f\2\2\2Q\2"+
		"\17\3\2\2\2\4\27\3\2\2\2\6\31\3\2\2\2\b)\3\2\2\2\n/\3\2\2\2\f;\3\2\2\2"+
		"\16\20\5\4\3\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2"+
		"\22\23\3\2\2\2\23\24\7\2\2\3\24\3\3\2\2\2\25\30\5\6\4\2\26\30\5\b\5\2"+
		"\27\25\3\2\2\2\27\26\3\2\2\2\30\5\3\2\2\2\31\32\7\t\2\2\32\35\b\4\1\2"+
		"\33\34\7\7\2\2\34\36\b\4\1\2\35\33\3\2\2\2\35\36\3\2\2\2\36\"\3\2\2\2"+
		"\37 \7\3\2\2 !\7\7\2\2!#\b\4\1\2\"\37\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\7"+
		"\4\2\2%&\5\n\6\2&\'\b\4\1\2\'(\7\5\2\2(\7\3\2\2\2)*\7\n\2\2*+\7\4\2\2"+
		"+,\7\13\2\2,-\7\5\2\2-.\b\5\1\2.\t\3\2\2\2/\60\b\6\1\2\60\61\5\f\7\2\61"+
		"8\b\6\1\2\62\63\7\6\2\2\63\64\5\f\7\2\64\65\b\6\1\2\65\67\3\2\2\2\66\62"+
		"\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\13\3\2\2\2:8\3\2\2\2;J\b\7"+
		"\1\2<G\b\7\1\2=>\7\b\2\2>H\b\7\1\2?@\7\t\2\2@C\b\7\1\2AB\7\7\2\2BD\b\7"+
		"\1\2CA\3\2\2\2CD\3\2\2\2DH\3\2\2\2EF\7\n\2\2FH\b\7\1\2G=\3\2\2\2G?\3\2"+
		"\2\2GE\3\2\2\2HI\3\2\2\2IK\b\7\1\2J<\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2"+
		"\2\2M\r\3\2\2\2\n\21\27\35\"8CGL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}