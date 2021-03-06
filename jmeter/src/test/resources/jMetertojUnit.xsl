<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/testResults">
        <testsuites>
            <testsuite>
                <xsl:for-each select="*">
                    <testcase>
                        <xsl:attribute name="classname"><xsl:value-of select="name()"/></xsl:attribute>
                        <xsl:attribute name="name"><xsl:value-of select="@lb"/></xsl:attribute>
                        <xsl:attribute name="time"><xsl:value-of select="@lt div 1000"/></xsl:attribute>
                        <xsl:if test="assertionResult/failureMessage">
                            <failure><xsl:value-of select="assertionResult/failureMessage"/></failure>
                        </xsl:if>
                        <xsl:if test="@s = 'false'">
                            <xsl:if test="responseData">
                                <error><xsl:value-of select="responseData"/></error>
                            </xsl:if>
                        </xsl:if>
                    </testcase>
                </xsl:for-each>
            </testsuite>
        </testsuites>
    </xsl:template>
</xsl:stylesheet>