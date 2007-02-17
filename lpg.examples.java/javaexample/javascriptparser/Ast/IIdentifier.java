package javascriptparser.Ast;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>Identifier0
 *<li>Identifier1
 *<li>Identifier2
 *<li>Identifier3
 *</ul>
 *</b>
 */
public interface IIdentifier extends IAstToken, ISimpleQualifiedIdentifier, IPragmaExpr, ITypedIdentifier_allowIn, ITypedIdentifier_noIn, IFunctionName, IPackageIdentifiers {}


