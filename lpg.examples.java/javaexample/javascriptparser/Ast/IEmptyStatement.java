package javascriptparser.Ast;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by <b>EmptyStatement</b>
 */
public interface IEmptyStatement extends ISubstatement_abbrev, ISubstatement_noShortIf, ISubstatement_full, IAstToken, IDirective_abbrev, IDirective_full {}


