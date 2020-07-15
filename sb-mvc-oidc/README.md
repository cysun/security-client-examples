# Spring Boot MVC OpenID Connect Client Example

## Project Creation

The project was created using [Spring Initializr](https://start.spring.io/) with the
following dependencies:
  * Spring Boot DevTools
  * Spring Web
  * OAuth2 Client
  * Thymeleaf

Although I'm not a fan of Thymeleaf (I think its syntax is editor-friendly but
human-unfriendly), I choose to use Thymeleaf instead of FreeMarker because
Eclipse doesn't support FreeMarker templates, and the FreeMarker IDE from
JBoss Tools 1.5 plugin causes an exception every time I start Eclipse (I guess
this shows that being editor-friendly is kind of important).

## OpenID Connect Configuration

Copy `application.yml.sample` to `application.yml` and modify it
according to your setup. In particular:

  * Registration ID is just an arbitrary name. In the sample file it's `ais`
    (which stands for Alice Identity Service in case you are wondering), but
    you could use any name for this. Note that it appears twice in the
    configuration.
  * `client-name` doesn't really matter.
  * Just keep `redirect-uri` from the sample - it automatically gets
    the `baseUrl` and `registrationId`.
  * You can add additional scopes if you want (of course the server needs to
    be configured to allow this client to request those scopes).
  * `issuer-uri` is the URL of the OpenID Connect service.

Currently Spring Security does not support PKCE for confidential clients (see
[this issue](https://github.com/spring-projects/spring-security/issues/6548)).
IdentityServer4 sets the client property `RequirePKCE` to true by
default - it needs to be changed to false in order for this client to authenticate
properly.

## Authorization

We use simple URL-based authorization in this example.

  * `/` (or `/index`) allows anonymous access.
  * `/member` requires authentication.
  * `/admin` requires `sb_mvc_admin` claim.